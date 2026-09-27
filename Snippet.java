
package com.miniproject_car;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Image;

public class Snippet {

    public static void main(String[] args) {

        // Image path
        String imagePath =
                "C:\\Users\\thris\\OneDrive\\Desktop\\car.jpg";

        // Load image
        ImageIcon originalIcon =
                new ImageIcon(imagePath);

        // Check whether image exists
        if (originalIcon.getIconWidth() == -1) {

            System.out.println(
                    "Image not found!"
            );

            return;
        }

        // Resize image
        Image image =
                originalIcon.getImage()
                        .getScaledInstance(
                                800,
                                500,
                                Image.SCALE_SMOOTH
                        );

        // Create ImageIcon with resized image
        ImageIcon imageIcon =
                new ImageIcon(image);

        // Create label
        JLabel imageLabel =
                new JLabel(imageIcon);

        // Create frame
        JFrame frame =
                new JFrame(
                        "Car Background Image"
                );

        // Add image
        frame.add(imageLabel);

        // Frame size
        frame.setSize(
                800,
                500
        );

        // Close operation
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        // Center window
        frame.setLocationRelativeTo(
                null
        );

        // Show window
        frame.setVisible(
                true
        );
    }
}