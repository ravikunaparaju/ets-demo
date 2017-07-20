Feature: As a user I should be able to search for a product from home screen

  Scenario: User should be able to search for a product from the input box
    Given John is viewing the Etsy landing page
    When he searches for a product "anklet" from the input box
    Then the result for "anklet" should be displayed

  Scenario: User should be able to search for a product from the drop-down menu
	Given John is viewing the Etsy landing page
    When he clicks for a product from drop-down menu 
    Then the results for the product should be displayed
  
  Scenario: Should be able to search for a product from the icons
	Given John is viewing the Etsy landing page
    When he clicks on a product icon
    Then the results related to the product category are displayed
   
  
	
