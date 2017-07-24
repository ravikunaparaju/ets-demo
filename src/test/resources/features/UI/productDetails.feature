Feature: As a user I should be able to view list of products by category

	Scenario Outline: User should be able to view list of products by category
		Given John is viewing the Etsy landing page
    	When he selects a "<product type>" from "<category>" 
    	And clicks on product from the list
   		Then product details for the selected product should be displayed
   	
   	Examples:
   		|categories|producttype|
   		|Body Jewellery	|Anklets|
   		|Weddings		|Hats	|	
   	
   		