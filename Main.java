
import javax.swing.*;

public class Main {

    // Method to resize product images
    public static ImageIcon resizeImage(String path) {

        ImageIcon icon = new ImageIcon(path);

        java.awt.Image img = icon.getImage();

        java.awt.Image newImg = img.getScaledInstance(
            120, 100,
            java.awt.Image.SCALE_SMOOTH
        );

        return new ImageIcon(newImg);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Sweet Treats Bakery");

        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Background Color
        frame.getContentPane().setBackground(
            new java.awt.Color(255, 240, 245)
        );

        // Bakery Heading
        JLabel title = new JLabel("Welcome to Sweet Treats Bakery");
        title.setBounds(170, 20, 450, 40);

        title.setFont(new java.awt.Font(
            "Arial", java.awt.Font.BOLD, 22
        ));

        title.setForeground(
            new java.awt.Color(180, 50, 100)
        );

        // Menu Heading
        JLabel menu = new JLabel("Our Bakery Products");
        menu.setBounds(250, 70, 300, 30);

        menu.setFont(new java.awt.Font(
            "Arial", java.awt.Font.BOLD, 18
        ));

        // Chocolate Cake
        JLabel cake = new JLabel("Chocolate Cake - Rs.500");
        cake.setBounds(50, 120, 220, 30);

        ImageIcon cakeImage = resizeImage("images/cakeeeee.jpg");
        JLabel cakePic = new JLabel(cakeImage);
        cakePic.setBounds(50, 150, 120, 100);

        JCheckBox cakeBox = new JCheckBox("Add to Cart");
        cakeBox.setBounds(50, 260, 150, 30);

        // Donut
        JLabel donut = new JLabel("Donut - Rs.80");
        donut.setBounds(380, 120, 200, 30);

        ImageIcon donutImage = resizeImage("images/donutss.jpg");
        JLabel donutPic = new JLabel(donutImage);
        donutPic.setBounds(380, 150, 120, 100);

        JCheckBox donutBox = new JCheckBox("Add to Cart");
        donutBox.setBounds(380, 260, 150, 30);

        // Cookies
        JLabel cookies = new JLabel("Cookies - Rs.100");
        cookies.setBounds(50, 310, 200, 30);

        ImageIcon cookiesImage = resizeImage("images/coookieee.jpg");
        JLabel cookiesPic = new JLabel(cookiesImage);
        cookiesPic.setBounds(50, 340, 120, 100);

        JCheckBox cookiesBox = new JCheckBox("Add to Cart");
        cookiesBox.setBounds(50, 450, 150, 30);

        // Cupcake
        JLabel cupcake = new JLabel("Cupcake - Rs.60");
        cupcake.setBounds(380, 310, 200, 30);

        ImageIcon cupcakeImage = resizeImage("images/cupcakeee.jpg");
        JLabel cupcakePic = new JLabel(cupcakeImage);
        cupcakePic.setBounds(380, 340, 120, 100);

        JCheckBox cupcakeBox = new JCheckBox("Add to Cart");
        cupcakeBox.setBounds(380, 450, 150, 30);

        // View Cart Button
        JButton cart = new JButton("View Cart");
        cart.setBounds(260, 500, 150, 40);

        cart.setBackground(
            new java.awt.Color(220, 80, 130)
        );

        cart.setForeground(java.awt.Color.WHITE);

        cart.setFont(new java.awt.Font(
            "Arial", java.awt.Font.BOLD, 14
        ));

        // View Cart Button Action
        cart.addActionListener(e -> {

            JFrame cartFrame = new JFrame("My Order");

            cartFrame.setSize(400, 400);
            cartFrame.setLayout(null);

            cartFrame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
            );

            cartFrame.getContentPane().setBackground(
                new java.awt.Color(255, 240, 245)
            );

            JLabel heading = new JLabel("Your Bakery Order");
            heading.setBounds(120, 20, 200, 30);

            heading.setFont(new java.awt.Font(
                "Arial", java.awt.Font.BOLD, 18
            ));

            cartFrame.add(heading);

            int total = 0;
            int y = 70;

            // Selected Chocolate Cake
            if (cakeBox.isSelected()) {

                JLabel item = new JLabel("Chocolate Cake - Rs.500");
                item.setBounds(70, y, 250, 30);

                cartFrame.add(item);

                total = total + 500;
                y = y + 40;
            }

            // Selected Donut
            if (donutBox.isSelected()) {

                JLabel item = new JLabel("Donut - Rs.80");
                item.setBounds(70, y, 250, 30);

                cartFrame.add(item);

                total = total + 80;
                y = y + 40;
            }

            // Selected Cookies
            if (cookiesBox.isSelected()) {

                JLabel item = new JLabel("Cookies - Rs.100");
                item.setBounds(70, y, 250, 30);

                cartFrame.add(item);

                total = total + 100;
                y = y + 40;
            }

            // Selected Cupcake
            if (cupcakeBox.isSelected()) {

                JLabel item = new JLabel("Cupcake - Rs.60");
                item.setBounds(70, y, 250, 30);

                cartFrame.add(item);

                total = total + 60;
                y = y + 40;
            }

            // Check Product Selection
            if (total == 0) {

                JOptionPane.showMessageDialog(
                    frame,
                    "Please select at least one product!"
                );

                return;
            }

            // Display Total Amount
            JLabel amount = new JLabel(
                "Total Amount: Rs." + total
            );

            amount.setBounds(70, y + 10, 250, 30);

            amount.setFont(new java.awt.Font(
                "Arial", java.awt.Font.BOLD, 15
            ));

            cartFrame.add(amount);

            // Place Order Button
            JButton order = new JButton("Place Order");

            order.setBounds(110, y + 60, 150, 30);

            order.setBackground(
                new java.awt.Color(220, 80, 130)
            );

            order.setForeground(java.awt.Color.WHITE);

            // Place Order Action
            order.addActionListener(a -> {

                JOptionPane.showMessageDialog(
                    cartFrame,
                    "Your Order Placed Successfully!"
                );

                cartFrame.dispose();
            });

            cartFrame.add(order);

            cartFrame.setVisible(true);
        });

        // Adding Components to Frame
        frame.add(title);
        frame.add(menu);

        frame.add(cake);
        frame.add(cakePic);
        frame.add(cakeBox);

        frame.add(donut);
        frame.add(donutPic);
        frame.add(donutBox);

        frame.add(cookies);
        frame.add(cookiesPic);
        frame.add(cookiesBox);

        frame.add(cupcake);
        frame.add(cupcakePic);
        frame.add(cupcakeBox);

        frame.add(cart);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
