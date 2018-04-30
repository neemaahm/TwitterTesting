/**
 * Created by Neema on 2/10/2018.
 */
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.util.ArrayList;
import java.util.Timer;

public class Driver {
    public static void main(String[] args){

        //Timer time1 = new Timer();
        //time1.schedule(new MyLooper(), 0,6000);

        MyTwitter myTwitter = new MyTwitter();
        System.out.println(myTwitter.getLatestTweet());
        System.out.println("RUN");
        /*System.out.println("Message: " + myTwitter.getLatestTweet());
        for (int i=0; i<10; i++) {
            try {
                System.out.println(myTwitter.getLatestTweet());//print something here
                Thread.sleep(3000); //sleep for 3 seconds
                System.out.println("END");//print something else here
            } catch (InterruptedException e) {
                System.out.println("got interrupted!");
            }
        }*/

        System.out.println("____________________");
        TwitterData tweet1 = new TwitterData("Bobby", myTwitter.getLatestTweet());
        tweet1.generateCommand();
        System.out.println("Duration: " + tweet1.updateDuration());

    }
}

/**/

/**
 * Notes to Self:
 * Cry
 * How to add extrenal lib: https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project
 */
/*ConfigurationBuilder cb = new ConfigurationBuilder();
        Twitter twitterInstance;
        Query query4Twitter;

        cb.setOAuthConsumerKey("0aKiWf9V25gvp7NLEusPAgTu2");
        cb.setOAuthConsumerSecret("f2Z4XlCl23wyTjwg2Xx3971rqePCcRhDtgkPbcy8RkWo4HbDpA");
        cb.setOAuthAccessToken("962397751614099457-GASkR2zpKt6IVqai1J0xv6Dg1ommEgP");
        cb.setOAuthAccessTokenSecret("l33lf3XxscvwSXiCcW4mhw8G8S7etM4uDLvLHn9Lr3MFr");

        twitterInstance = new TwitterFactory(cb.build()).getInstance();

        query4Twitter = new Query("#TORCS");

        try{
            int index = 0;
            boolean incomplete = true;
            QueryResult result = twitterInstance.search(query4Twitter);
            Status t;
            while (incomplete) {
                t = (Status) result.getTweets().get(index);
                String user = t.getUser().getName();
                String msg = t.getText();
                if (msg.contains("@TORCS_Rover")) {
                    System.out.println(user + "-------- " + msg);
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