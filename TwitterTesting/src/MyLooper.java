/**
 * Created by Neema on 4/28/2018.
 */
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.util.*;

public class MyLooper extends TimerTask{
    private int counter = 0;
    private TwitterData myData;

    public void run() {
        System.out.println(counter);
        counter++;
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
        }
    }

    public void run(int countTo) {
        if (countTo > 0 && counter < countTo) {
            System.out.println(counter);
            counter++;
            ConfigurationBuilder cb = new ConfigurationBuilder();
            Twitter twitterInstance;
            Query query4Twitter;

            cb.setOAuthConsumerKey("0aKiWf9V25gvp7NLEusPAgTu2");
            cb.setOAuthConsumerSecret("f2Z4XlCl23wyTjwg2Xx3971rqePCcRhDtgkPbcy8RkWo4HbDpA");
            cb.setOAuthAccessToken("962397751614099457-GASkR2zpKt6IVqai1J0xv6Dg1ommEgP");
            cb.setOAuthAccessTokenSecret("l33lf3XxscvwSXiCcW4mhw8G8S7etM4uDLvLHn9Lr3MFr");

            twitterInstance = new TwitterFactory(cb.build()).getInstance();

            query4Twitter = new Query("#TORCS");

            try {
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
                    } else {
                        System.out.println("invalid message contents  :  " + index);
                        index++;
                    }

                }
            } catch (TwitterException te) {
                System.out.println("Couldn't connect: " + te);
            }
        } else{
                counter = 0;
                this.cancel();
        }
    }

    public TwitterData getMyData(){
        return myData;
    }

}
