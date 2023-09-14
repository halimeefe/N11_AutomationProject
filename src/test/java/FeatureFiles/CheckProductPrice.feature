


@Parallel
Feature: Location Specific Delivery Control


  Scenario: Location Specific Delivery Price Check

    Given Navigate to Website
    When Verify you are on N11 Home Page
    And Click Login
    And Verify successfully loged
    And The User clicks on the Book,Music,Film,Game category
    And The User clicks on KidsToys-Party category
    And The User selects Location-Specific Delivery
    And The User checks the location-specific price of the product
    When The User adds the product in the cart
    Then The user goes to the cart
    And The User compares the location-specific price with the price in the cart
    When  The user removes the product from the cart
    Then Verify the cart is empty
    And Logout on the website




#  Bu proje bir e-ticaret sitesinde  konuma özel teslimat seçeneği kullanılarak ürün fiyatı
#  kontrol edilmesi için tasarlanmıştır.Sepetteki fiyat ile konuma özel fiyat arasındaki tutarsızlık tespit edilip
#  doğrulaması yapılmıştır.Projede Cucumber BDD Framework kullanılmıştır.Sonuçlar ScreenShot alınarak tarih ve saatiyle
#  birlikte Excel Report ile belgelenmiştir.
#
