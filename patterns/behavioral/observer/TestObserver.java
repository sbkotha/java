package patterns.behavioral.observer;

public class TestObserver {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel("Telugu Music");
        YouTubeUser user1 = new YouTubeUser("Suresh");
        user1.setChannel(channel);
        YouTubeUser user2 = new YouTubeUser("Sowjanya");
        user2.setChannel(channel);
        YouTubeUser user3 = new YouTubeUser("Chandan");
        user3.setChannel(channel);
        YouTubeUser user4 = new YouTubeUser("Sanjana");
        user4.setChannel(channel);
        YouTubeUser user5 = new YouTubeUser("Harshitha");
        user5.setChannel(channel);
        YouTubeUser user6 = new YouTubeUser("Teja");
        user6.setChannel(channel);

        channel.subscribe(user1);
        channel.subscribe(user2);
        channel.subscribe(user3);
        channel.subscribe(user4);
        channel.subscribe(user5);
        channel.subscribe(user6);

        channel.uploadSong();
    }
}
