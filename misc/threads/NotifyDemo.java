package misc.threads;

public class NotifyDemo {

    public static void main(String[] args) {
        Message message = new Message();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                message.draftMessage();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                message.sendEmail();
            }
        });

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                message.sendFax();
            }
        });

        t2.start();
        t3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
    }
}

class Message {
    volatile boolean messagedDrafted = false;

    synchronized void draftMessage() {
        System.out.println("draftMessage(): Request received to draft a message");

        System.out.println("draftMessage(): Drafting the message");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        messagedDrafted = true;
        System.out.println("draftMessage(): Drafting completed");
        notifyAll();
    }

    synchronized void sendEmail() {
        System.out.println("sendEmail(): Request received to send message by Email");
        while (!messagedDrafted) {
            try {
                System.out.println("sendEmail(): Message is not drafted yet. Waiting for it to complete.");
                wait();
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
        }
        try {
            System.out.println("sendEmail(): Sending Email");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail(): Sent Email");
    }

    synchronized void sendFax() {
        System.out.println("sendFax(): Request received to send message by Fax");
        while (!messagedDrafted) {
            try {
                System.out.println("sendFax(): Message is not drafted yet. Waiting for it to complete.");
                wait();
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
        }
        try {
            System.out.println("sendFax(): Sending Fax");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendFax(): Sent Fax");
    }

}