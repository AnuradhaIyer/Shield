package edu.sjsu.sample;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class SimpleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String consumerKeyStr = "Y6oETI68468kyFTJrtIr72KJN";
		String consumerSecretStr = "m7cDS8snMfr2erJPEGh21pZjngEBKYnw2Km6AGQGFUmhdxaAcJ";
		String accessTokenStr = "910234730183794688-qDk13KxpS8bnDzVbh7vCEZ07YNBF6Gj";
		String accessTokenSecretStr = "tQxgqvuqIY30PZWAPuDHZELgEZH9IJDr6POj9T6EQ8NOa";

		try {
			OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr, consumerSecretStr);
			oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);
			// HttpGet httprequest = new
			// HttpGet("https://api.twitter.com/1.1/followers/ids.json?cursor=-1&screen_name=AnushriSAithal"); //someone can do this
			// HttpGet httprequest = new
			// HttpGet("https://api.twitter.com/1.1/statuses/home_timeline.json"); // I am doing this
			HttpGet httprequest = new HttpGet("https://api.twitter.com/1.1/search/tweets.json?q=%23bigboss&count=4"); //I am doing this

			oAuthConsumer.sign(httprequest);

			HttpClient client = new DefaultHttpClient();
			HttpResponse httpresponse = client.execute(httprequest);

			int statusCode = httpresponse.getStatusLine().getStatusCode();
			System.out.println(statusCode + ":" + httpresponse.getStatusLine().getReasonPhrase());
			// System.out.println(IOUtils.toString(httpresponse.getEntity().getContent()));

			// JSONArray json = new JSONArray(EntityUtils.toString(httpresponse.getEntity())); for timeline api
			JSONObject jsonobject = new JSONObject(EntityUtils.toString(httpresponse.getEntity())); //for search api
			JSONArray arr = (JSONArray) jsonobject.get("statuses");
			JSONObject object = (JSONObject) arr.get(0);
			String tweetText = (String) object.get("text");
			// System.out.println(tweetText);
			request.getSession().setAttribute("tweet", tweetText);
			// System.out.println(json);
		} catch (OAuthMessageSignerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthExpectationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthCommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * ConfigurationBuilder configBuilder = new ConfigurationBuilder();
		 * configBuilder.setDebugEnabled(true);
		 * configBuilder.setOAuthConsumerKey("Y6oETI68468kyFTJrtIr72KJN");
		 * configBuilder.setOAuthConsumerSecret(
		 * "m7cDS8snMfr2erJPEGh21pZjngEBKYnw2Km6AGQGFUmhdxaAcJ");
		 * configBuilder.setOAuthAccessToken(
		 * "910234730183794688-qDk13KxpS8bnDzVbh7vCEZ07YNBF6Gj");
		 * configBuilder.setOAuthAccessTokenSecret(
		 * "tQxgqvuqIY30PZWAPuDHZELgEZH9IJDr6POj9T6EQ8NOa"); TwitterFactory
		 * twitterFactory = new TwitterFactory(configBuilder.build()); Twitter twitter =
		 * twitterFactory.getInstance(); Query query = new Query("bigboss"); QueryResult
		 * result; try { result = twitter.search(query); for (Status status :
		 * result.getTweets()) { System.out.println("@" +
		 * status.getUser().getScreenName() + " : " + status.getText() + " : " +
		 * status.getGeoLocation()); } request.getSession().setAttribute("tweet",
		 * result.getTweets().get(0).getText()); } catch (TwitterException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(request, response);
	}
}
