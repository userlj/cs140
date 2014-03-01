package assignment05;

public class MenuTestDrive {
    public static void main(String args[]) {
        MenuAbstraction pancakeHouseMenu = 
        	new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuAbstraction dinerMenu = 
            new Menu("DINER MENU", "Lunch");
        MenuAbstraction cafeMenu = 
            new Menu("CAFE MENU", "Dinner");
        MenuAbstraction dessertMenu = 
            new Menu("DESSERT MENU", "Dessert of course!");
        MenuAbstraction coffeeMenu = new Menu("COFFEE MENU", "Stuff to go with your afternoon coffee");
  
        MenuAbstraction allMenus = new Menu("ALL MENUS", "All menus combined");
  
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(dessertMenu);
        allMenus.add(cafeMenu);
        allMenus.add(coffeeMenu);

//pancake house menu  
        MenuAbstraction pancake1 = 
            	new MenuPart("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
        pancakeHouseMenu.add(pancake1);
        MenuAbstraction pancake2 = 
            	new MenuPart("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
        pancakeHouseMenu.add(pancake2);
        MenuAbstraction pancake3 = 
            	new MenuPart("Blueberry Pancakes", "Pancakes made with fresh blueberries, and blueberry syrup", true, 3.49);
        pancakeHouseMenu.add(pancake3);
        MenuAbstraction pancake4 = 
            	new MenuPart("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
        
        pancakeHouseMenu.add(pancake4);
//diner menu
        MenuAbstraction diner1 = 
            	new MenuPart("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        
        dinerMenu.add(diner1);
        MenuAbstraction diner2 = 
            	new MenuPart("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        
        dinerMenu.add(diner2);
        MenuAbstraction diner3 = 
            	new MenuPart("Soup of the day", "A bowl of the soup of the day, with a side of potato salad", false, 3.29);
        
        dinerMenu.add(diner3);
        MenuAbstraction diner4 = 
            	new MenuPart("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05);
        
        dinerMenu.add(diner4);
        MenuAbstraction diner5 = 
            	new MenuPart("Steamed Veggies and Brown Rice", "Steamed vegetables over brown rice", true, 3.99);
        
        dinerMenu.add(diner5);
        MenuAbstraction diner6 = 
            	new MenuPart("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89);
        
        dinerMenu.add(diner6);
//dessert menu
        MenuAbstraction dessert1 = 
            	new MenuPart("Apple Pie", "Apple pie with a flakey crust, topped with vanilla icecream", true, 1.59);
        
        dessertMenu.add(dessert1);
        MenuAbstraction dessert2 = 
            	new MenuPart("Cheesecake", "Creamy New York cheesecake, with a chocolate graham crust", true, 1.99);
        
        dessertMenu.add(dessert2);
        MenuAbstraction dessert3 = 
            	new MenuPart("Sorbet", "A scoop of raspberry and a scoop of lime", true, 1.89);
        
        dessertMenu.add(dessert3);
//cafe menu
        MenuAbstraction cafe1 = 
            	new MenuPart("Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 3.99);
        
        cafeMenu.add(cafe1);
        MenuAbstraction cafe2 = 
            	new MenuPart("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.69);
        
        cafeMenu.add(cafe2);
        MenuAbstraction cafe3 = 
            	new MenuPart("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29);
        
        cafeMenu.add(cafe3);
//coffee menu
        MenuAbstraction coffee1 = 
            	new MenuPart("Coffee Cake", "Crumbly cake topped with cinnamon and walnuts", true, 1.59);
        
        coffeeMenu.add(coffee1);
        MenuAbstraction coffee2 = 
            	new MenuPart("Bagel", "Flavors include sesame, poppyseed, cinnamon raisin, pumpkin", false, 0.69);
        
        coffeeMenu.add(coffee2);
        MenuAbstraction coffee3 = 
            	new MenuPart("Biscotti", "Three almond or hazelnut biscotti cookies", true, 0.89);
        
        coffeeMenu.add(coffee3);
        
        
        allMenus.print();
        Visitor vis = new RaisePriceVisitor(10);
        allMenus.accept(vis);
        allMenus.print();
    }
    
}