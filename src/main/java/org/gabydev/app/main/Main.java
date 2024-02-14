package org.gabydev.app.main;


import org.gabydev.app.model.User;

public class Main {
    public static void main(String[] args) {

        User user = User.getUserById(2);

        System.out.println(user);

//        user.deleteFavoriteMovie(12);

        user.deleteFavoriteMovie(13);

//        user.updateFullName("Emily Davis");
//        user.updateNickname("Emily");
//        user.updateEmail("emily_davise@mail.com");
//        user.updatePassword("P@ss123456");

//        System.out.println("Movies");
//        user.getMyFavoriteMovies().forEach(System.out::println);
    }
}
