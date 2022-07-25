# demo-burger-shop

The following project is a code challenge and the functional requirements are as follows:

The aim is to help a burger company manage their process of selling hamburgers.

User stories

Create a base hamburger and two other types of hamburgers.
All burgers should have bread type and one meat topping.
Bread types: Wholegrain, White, Brioche, Ciabatta
Meat choices : Black angus patty, Kobe beef patty, Vegan patty, Fish patty

The basic hamburger should have the following items:
Up to 4 additional toppings (e.g. cheese, sauces, lettuce, tomato, union, etc) that the customer can select to be added to the burger.
Each one of these items gets charged an additional price.
So you need some way to track how many items got added.
The burger has a base price and the toppings/additions are all separately priced.
And calculate the final price (base burger with all the toppings/additions).

The healthy burger should have the following:
It can have 6 toppings in total.

The combo burger should have the following:
Comes with chips and drinks as additions
No (extra) toppings are allowed.

    All burgers should be able to output:
    Base price of the hamburger.
    Each topping name.
    Topping price.
    And a grand total for the burger (base price + all toppings / additions).

Goal

    Publish it to git and share.
    Provide unit tests

Pre-requisites

    Maven
    Java 11

How to run
    
    Navigate to where pom.xml is located
    On the console run "mvn clean install"(Tests will run) 
    On the folder where the maven compiler installed the jar run "java -cp  burger-shop-1.0.jar Main"

