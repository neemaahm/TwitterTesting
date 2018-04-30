/**
 * Created by Neema on 4/26/2018.
 */
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;

public class TestDriver {
    public static void main(String[] args){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        Twitter twitterInstance;
        Query query4Twitter;

        cb.setOAuthConsumerKey("0aKiWf9V25gvp7NLEusPAgTu2");
        cb.setOAuthConsumerSecret("f2Z4XlCl23wyTjwg2Xx3971rqePCcRhDtgkPbcy8RkWo4HbDpA");
        cb.setOAuthAccessToken("962397751614099457-GASkR2zpKt6IVqai1J0xv6Dg1ommEgP");
        cb.setOAuthAccessTokenSecret("l33lf3XxscvwSXiCcW4mhw8G8S7etM4uDLvLHn9Lr3MFr");

        twitterInstance = new TwitterFactory(cb.build()).getInstance();

        query4Twitter = new Query("#TORCS");

        try{
            QueryResult result = twitterInstance.search(query4Twitter);
            ArrayList tweets = (ArrayList) result.getTweets();
            for (int i = 0; i<tweets.size(); i++){
                Status t = (Status) tweets.get(i);
                String username = t.getUser().getName();
                String msg = t.getText();
                System.out.println(username + " ----- " + msg);
            }
        } catch(TwitterException te) {
            System.out.println("Couldn't connect: " + te);
        }

        /*try{
            int index = 0;
            boolean incomplete = true;
            QueryResult result = twitterInstance.search(query4Twitter);
            Status t;
            while (incomplete){
                t = (Status) result.getTweets().get(index);
                String username = t.getUser().getName();
                String msg = t.getText();
                if (msg.contains("@TORCS_Rover")){
                    System.out.println(username + " ----- " + msg);
                    incomplete = false;
                }
                else {
                    System.out.println("invalid message contents  :  " + index);
                    index++;
                }
            }
        } catch(TwitterException te) {
            System.out.println("Couldn't connect: " + te);
        }*/
    }
}
