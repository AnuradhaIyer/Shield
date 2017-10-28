package twitterkaraf;

import java.util.List;

import org.junit.Test;

import edu.sjsu.twitterkaraf.TwitterHelper;
import junit.framework.Assert;

/**
 * @author Anushri Srinath Aithal
 * Nidhi Jamar
 * Ashwini Shankar Narayan
 * Anuradha Rajashekar
 *
 */
@SuppressWarnings("deprecation")
public class AppTest {

	TwitterHelper twitterHelper = new TwitterHelper();
	
	/**
	 * @author Anushri Srinath Aithal
	 * JUnit test case to search based on hashtag
	 * Success if response is not null
	 * Cannot check for specific response as data is real time
	 */
	@Test
	public void testSearchHashTag() {
		List<String> response = twitterHelper.searchHashTag("irma");
		Assert.assertNotNull(response);
	}
	
	/**
	 * @author Anushri Srinath Aithal
	 * JUnit test case to check tweets on timeline
	 * Success if response is not null
	 * Cannot check for specific response as data is real time
	 */
	@Test
	public void testHomeTimeline() {
		List<String> response = twitterHelper.homeTimeline();
		Assert.assertNotNull(response);
	}
	
	@Test
	public void testTrendsClosest() {
		List<String> response = twitterHelper.trendsClosest();
		Assert.assertNotNull(response);
	}
	
	@Test
	public void testFollowersList() {
		List<String> response = twitterHelper.followersList("Abc");
		Assert.assertNotNull(response);
	}
	
	@Test
	public void testCreateFriendship() {
		List<String> response = twitterHelper.createFriendship("abc");
		Assert.assertNotNull(response);
	}
	
	@Test
	public void testStatusUpdate() {
		List<String> response = twitterHelper.statusUpdate("Test");
		Assert.assertNotNull(response);
	}
	
	@Test
	public void testTrendsAvailable() {
		List<String> response = twitterHelper.trendsAvailable();
		Assert.assertNotNull(response);
	}
	
	@Test
	public void testLanguageSupport() {
		List<String> response = twitterHelper.languageSupport();
		Assert.assertNotNull(response);
	}
}
