Feature: As a user I should be able to view list of products by category

	Scenario Outline: User should be able to view list of products by category
		Given John is viewing the Etsy landing page
    	When he selects a "<product type>" from "<category>" 
   		Then list of products for the "<product type>" should be displayed
   		
   	Examples:
   		|categories|producttype|
   		|Body Jewellery|Anklets|
   		|Body Jewellery|Armbands|
   		|Body Jewellery|Barbells|
   		|Body Jewellery|Belly Chains|
   		|Body Jewellery|Bell Rings|
   		|Body Jewellery|Gauge & Plug Earrings|
   		|Body Jewellery|Hair Jewellery|
   		|Body Jewellery	|Nipple Jewellery|
   		|Body Jewellery	|Nose Rings & Studs|
   		|Body Jewellery	|Pinchers & Spirals|
   		|Body Jewellery	|Shoulder Jewellery|
   		|Body Jewellery	|Toe Rings|
   		|Body Jewellery	|Lip Rings|

   		