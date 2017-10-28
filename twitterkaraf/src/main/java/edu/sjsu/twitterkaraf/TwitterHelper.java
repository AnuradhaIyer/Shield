package edu.sjsu.twitterkaraf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

/**
 * Helper Class to invoke all Twitter APIs Uses signpost to make http calls.
 * 
 * @author Anushri Srinath Aithal Nidhi Jamar Ashwini Shankar Narayan Anuradha
 *         Rajashekar
 *
 */
@SuppressWarnings({ "deprecation", "resource" })
public class TwitterHelper {

	/**
	 * Method to load the properties file while twitter tokens and api URLs are
	 * placed
	 * 
	 * @return Property File
	 * @throws IOException
	 * @author Anushri Srinath Aithal
	 */
	private Properties getProperties() throws IOException {
		InputStream input = this.getClass().getResourceAsStream("/properties/application.properties");
		Properties properties = new Properties();
		properties.load(input);
		return properties;
	}

	/**
	 * Create signpot OAuthConsumer to invoke Twitter APIs with right access tokens
	 * 
	 * @return OAuthConsumer
	 * @throws IOException
	 * @author Anushri Srinath Aithal
	 */
	public OAuthConsumer getOAuthConsumer() throws IOException {
		Properties properties = getProperties();
		String consumerKeyStr = properties.getProperty("twitter.consumer.key");
		String consumerSecretStr = properties.getProperty("twitter.consumet.secret");
		String accessTokenStr = properties.getProperty("twitter.access.token");
		String accessTokenSecretStr = properties.getProperty("twitter.access.secret");
		OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr, consumerSecretStr);
		oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);
		return oAuthConsumer;
	}

	/**
	 * Execute Http Post calls to invoke the post APIs
	 * 
	 * @param apiUrl
	 * @return
	 * @throws OAuthMessageSignerException
	 * @throws OAuthExpectationFailedException
	 * @throws OAuthCommunicationException
	 * @throws IOException
	 * @author Nidhi Jamar
	 * @author Anuradha Rajashekar
	 */
	private HttpResponse executeHttpPost(String apiUrl) throws OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException, IOException {
		HttpPost httprequest = new HttpPost(apiUrl);
		getOAuthConsumer().sign(httprequest);
		HttpClient client = new DefaultHttpClient();
		HttpResponse httpresponse = client.execute(httprequest);
		int statusCode = httpresponse.getStatusLine().getStatusCode();
		System.out.println(statusCode + ":" + httpresponse.getStatusLine().getReasonPhrase());
		return httpresponse;
	}

	/**
	 * Execute Http Get calls to invoke the Get APIs
	 * 
	 * @param apiUrl
	 * @return
	 * @throws OAuthMessageSignerException
	 * @throws OAuthExpectationFailedException
	 * @throws OAuthCommunicationException
	 * @throws IOException
	 * @author Anushri Srinath Aithal
	 * @author Ashwini Shankar Narayan
	 */
	private HttpResponse executeHttpGet(String apiUrl) throws OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException, IOException {
		HttpGet httprequest = new HttpGet(apiUrl);
		getOAuthConsumer().sign(httprequest);
		HttpClient client = new DefaultHttpClient();
		HttpResponse httpresponse = client.execute(httprequest);
		int statusCode = httpresponse.getStatusLine().getStatusCode();
		System.out.println(statusCode + ":" + httpresponse.getStatusLine().getReasonPhrase());
		return httpresponse;
	}

	/**
	 * Implementing Twitter API to search tweets based on Hash Tag
	 * 
	 * @param searchHashTag
	 * @return List of tweets, max of 10 records
	 * @author Anushri Srinath Aithal
	 */
	public List<String> searchHashTag(String searchHashTag) {
		List<String> twitterResponseList = new ArrayList<String>();
		try {
			Properties properties = getProperties();
			String apiUrl = properties.getProperty("twitter.api.search.tweets");
			apiUrl = apiUrl + "?count=10&q=%23" + searchHashTag; // appending API url with search string

			HttpResponse apiResponse = executeHttpGet(apiUrl);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONObject jsonobject = new JSONObject(EntityUtils.toString(apiResponse.getEntity())); // read json
																										// response
				JSONArray jsonArray = (JSONArray) jsonobject.get("statuses");
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = (JSONObject) jsonArray.get(i);
					JSONObject userObject = (JSONObject) jsonObject.get("user");

					String displayText = (String) userObject.get("screen_name") + " : "
							+ (String) jsonObject.get("text");
					twitterResponseList.add(displayText); // add tweet user name : tweet text
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return twitterResponseList;
	}

	/**
	 * Implementing Twitter API to allow the authenticated user to follow the
	 * specified user.
	 * 
	 * @param screen_name
	 * @return Message stating the status of the request.
	 * @author Nidhi Jamar
	 */
	public List<String> createFriendship(String screen_name) {
		List<String> twitterResponseList = new ArrayList<String>();
		try {
			Properties properties = getProperties();
			String apiUrl = properties.getProperty("twitter.api.createfriendship");
			apiUrl = apiUrl + "?screen_name=" + screen_name; //Appending API url with the user's screen name

			HttpResponse apiResponse = executeHttpPost(apiUrl);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				twitterResponseList.add("API call was Successful. Following User: "+ screen_name);
			} else {
				twitterResponseList.add("API call was Unsuccessful");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return twitterResponseList;
	}

	/**
	 * Implementing Twitter API to tweet/update status on authenticated user's
	 * timeline.
	 * 
	 * @param status
	 * @return Message stating the status of the request.
	 * @author Nidhi Jamar
	 */
	public List<String> statusUpdate(String status) {
		List<String> twitterResponseList = new ArrayList<String>();
		try {
			Properties properties = getProperties();
			String apiUrl = properties.getProperty("twitter.api.status.update");
			apiUrl = apiUrl + "?status=" + status.replace(" ", "%20"); //Appending the API url with the messgae to be tweeted.

			HttpResponse apiResponse = executeHttpPost(apiUrl);
			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				twitterResponseList.add("API call was Successful. Tweeted: "+ status );
			} else {
				twitterResponseList.add("API call was Unsuccessful");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return twitterResponseList;
	}
	
	/**
	 * Implementing Twitter API to get the location from where twitter has trending topics*
	 * @return Returns the locations that Twitter has trending topic information for.
	 * @author Anuradha Rajashekar
	 */

	public List<String> trendsAvailable() {
		List<String> twitterResponseList = new ArrayList<String>();
		try {
			Properties properties = getProperties();
			String apiUrl = properties.getProperty("twitter.api.trends.available");

			HttpResponse apiResponse = executeHttpGet(apiUrl);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONArray jsonArray = new JSONArray(EntityUtils.toString(apiResponse.getEntity()));
				for (int i = 1; i < jsonArray.length() && i <= 10; i++) {
					JSONObject object = (JSONObject) jsonArray.get(i);
					String displayText = (String) object.get("country") + " : " + (String) object.get("url");
					twitterResponseList.add(displayText);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return twitterResponseList;
	}
	/**
	 * Implementing twitter API to display all languages that twitter supports
	 * 
	 * @return List of languages supported by Twitter
	 * @author Ashwini Shankar Narayan
	 */
	public List<String> languageSupport() {
		List<String> twitterResponseList = new ArrayList<String>();
		try {
			Properties properties = getProperties();
			String apiUrl = properties.getProperty("twitter.api.language.support");

			HttpResponse apiResponse = executeHttpGet(apiUrl);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONArray jsonArray = new JSONArray(EntityUtils.toString(apiResponse.getEntity()));
				for (int i = 0; i < jsonArray.length() && i < 10; i++) {
					JSONObject object = (JSONObject) jsonArray.get(i);
					String displayText = (String) object.get("name");
					twitterResponseList.add(displayText);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return twitterResponseList;
	}

	/**
	 * Implementing twitter API to display tweets on home timeline
	 * 
	 * @return List of Tweets
	 * @author Anushri Srinath Aithal
	 */
	public List<String> homeTimeline() {
		List<String> twitterResponseList = new ArrayList<String>();
		try {
			Properties properties = getProperties();
			String apiUrl = properties.getProperty("twitter.api.home.timeline") + "?count=10"; // append count to max of
																								// 10

			HttpResponse apiResponse = executeHttpGet(apiUrl);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONArray jsonArray = new JSONArray(EntityUtils.toString(apiResponse.getEntity()));
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = (JSONObject) jsonArray.get(i);
					JSONObject userObject = (JSONObject) jsonObject.get("user");
					String displayText = (String) userObject.get("screen_name") + " : "
							+ (String) jsonObject.get("text"); // data to be displayed in screen_name : tweet format
					twitterResponseList.add(displayText); // list of data in the format mentioned above
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return twitterResponseList;

	}
	/**
	 * Implementing Twitter API to get the location nearest to user from where twitter has trending topics*
	 * @return Returns the locations that Twitter has trending topic information for, closest to a specified location.
	 * @author Anuradha Rajashekar
	 */

	public List<String> trendsClosest() {
		List<String> twitterResponseList = new ArrayList<String>();
		try {
			Properties properties = getProperties();
			String apiUrl = properties.getProperty("twitter.api.trends.closest") + "?lat=37.7749&long=122.4194";

			HttpResponse apiResponse = executeHttpGet(apiUrl);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONArray jsonArray = new JSONArray(EntityUtils.toString(apiResponse.getEntity()));
				for (int i = 0; i < jsonArray.length() && i < 10; i++) {
					JSONObject object = (JSONObject) jsonArray.get(i);
					String displayText = (String) object.get("country") + " : " + (String) object.get("url");
					twitterResponseList.add(displayText);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return twitterResponseList;
	}
	
	/**
	 * Implementing Twitter API to get the list of followers for the user.
	 * 
	 * @param seachstring
	 * @return Returns a cursored collection of user objects for users following the specified user.
	 * @author Anuradha Rajashekar
	 */

	public List<String> followersList(String searchStr) {
		List<String> twitterResponseList = new ArrayList<String>();
		try {
			Properties properties = getProperties();
			String apiUrl = properties.getProperty("twitter.api.follower.list") + "?screen_name=" + searchStr;

			HttpResponse apiResponse = executeHttpGet(apiUrl);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONObject jsonobject = new JSONObject(EntityUtils.toString(apiResponse.getEntity()));
				JSONArray jsonArray = (JSONArray) jsonobject.get("users");
				for (int i = 0; i < jsonArray.length() && i < 10; i++) {
					JSONObject object = (JSONObject) jsonArray.get(i);
					String displayText = (String) object.get("name") + " : " + (String) object.get("screen_name");
					twitterResponseList.add(displayText);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return twitterResponseList;
	}
}
