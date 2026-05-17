import java.util.Scanner;

public class SimpleChatBot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input;

        System.out.println("===== Customer Support ChatBot =====");
        System.out.println("Type 'hello' to start chatting");
        System.out.println("Type 'exit' to stop");

        while (true) {

            System.out.print("\nYou: ");
            input = sc.nextLine().toLowerCase();

            // Exit condition
            if (input.equals("exit")) {

                System.out.println("Bot: Thank you! Visit again.");
                break;
            }

            // Greeting
            else if (input.contains("hello") || input.contains("hi")) {

                System.out.println("Bot: Hello! How can I help you?");
            }

            // Balance check
            else if (input.contains("balance")) {

                System.out.println("Bot: Your account balance is Rs. 500.");
            }

            // Recharge help
            else if (input.contains("recharge")) {

                System.out.println("Bot: Recharge can be done using our mobile app.");
            }

            // Complaint
            else if (input.contains("complaint")) {

                System.out.println("Bot: Please describe your complaint.");
            }

            // Thanks
            else if (input.contains("thank")) {

                System.out.println("Bot: You're welcome!");
            }

            // Default response
            else {

                System.out.println("Bot: Sorry, I did not understand.");
            }
        }

        sc.close();
    }
}