/**Simple Search Engine
 Imagine you have a database which stores a large amount of user data.
 The user data stored in the database may have the following fields:
 - name (string, for example, "John Smith")
 - profession (string, for example, "Software Engineer")
 - age (number, for example, 31)
 You can add new fields or modify the existing if you would like.
 The data can be structured or unstructured. The manner in which the data is organized is up to you.
 Create a search engine which will search the entire database and return the information
 related to the search query. If the user does not type anything in the search input field,
 then all the entries in the database should be printed to the screen. Use any data for your tests.
 You can use a random data generator.

 (*)Bonus: Visualize your solution and give the user a nice interface to add, delete and search data.*/


//package com.company;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.company.Person.*;

class Person
{
    private final int id;
    private final String name;
    private final String surname;
    private final String work;
    private final int age;

    Person(int idDefinedByUser, String surnameDefinedByUser, String nameDefinedByUser, String workDefinedByUser, int ageDefinedByUser)
    {
        this.id = idDefinedByUser;
        this.surname = surnameDefinedByUser;
        this.name = nameDefinedByUser;
        this.work = workDefinedByUser;
        this.age = ageDefinedByUser;
    }
    private static final LinkedList<Person> peopleList = new LinkedList<>();
    private static final LinkedList<Person> searchedList = new LinkedList<>();
    private static final LinkedList<Person> removedList = new LinkedList<>();
    private static final LinkedList<Person> addedList = new LinkedList<>();
    public static LinkedList<Person> getPeopleList()
    {
        return peopleList;
    }
    public static LinkedList<Person> getSearchedList()
    {
        return searchedList;
    }
    public static LinkedList<Person> getRemovedList()
    {
        return removedList;
    }
    public static LinkedList<Person> getAddedList()
    {
        return addedList;
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getSurname()
    {
        return surname;
    }
    public String getWork()
    {
        return work;
    }
    public int getAge()
    {
        return age;
    }
    public static void displayAllPeople(LinkedList<Person> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println( (i+1) + ". [ id@" + list.get(i).id + " \\\\ " +
                    list.get(i).surname + " " + list.get(i).name +
                    " \\\\ " + list.get(i).work + " \\\\ " + list.get(i).age + " ]");
        }
        System.out.println();
    }
    public static void displayMenu()
    {
        System.out.println("\nShookay - the simple searching engine just for you\n" +
                "[ Menu ]\n" +
                "__________\n" +
                "1  Search |\n" +
                "2  Add    |\n" +
                "3  Remove |\n" +
                "4  Exit   |\n" +
                "__________\n");
        displayAllPeople(peopleList);
    }
    public void displayMatch()
    {
        System.out.println("|| ID: id@" + this.id + " ||\n" +
                "|| Name: " + this.surname + " " + this.name + " ||\n" +
                "|| Profession: " + this.work + " ||\n" +
                "|| Age: " + this.age + " ||\n");
    }
    public static void search()
    {
        Scanner inputSearch = new Scanner(System.in);
        System.out.println("Shookay: You are searching for: ");
        String search = inputSearch.nextLine().trim();
        if(Pattern.compile("([a-zA-Z\\d\\p{Punct}\\s]+)").matcher(search).matches()) {
            int result_counter = 0;

            for (Person p : peopleList) {
                if (Pattern.compile(".*" + search + ".*$").matcher(p.name).matches()
                        || Pattern.compile(".*" + search + ".*$").matcher(p.surname).matches()
                        || Pattern.compile(".*" + search + ".*$").matcher(p.work).matches()
                        || Pattern.compile(".*" + search + ".*$").matcher(Integer.toString(p.age)).matches()) {
                    result_counter++;
                    searchedList.add(p);
                }
            }
            if (result_counter > 0) {
                System.out.println("\n" + result_counter + " Matching results found: \n");
                if (search.length() == 0) {
                    displayAllPeople(peopleList);
                } else {
                    for (int i = 0; i < searchedList.size(); i++) {
                        System.out.println("Match " + (i + 1) + ":");
                        searchedList.get(i).displayMatch();
                    }
                }
                System.out.println("Would you like to remove these entries?\n" +
                        "1. Yes\n" +
                        "2. No");
                int userChoice = inputSearch.nextInt();
                if (userChoice == 1) {
                    int entry = 0;
                    searchedList.sort(Comparator.comparingInt(Person::getId).reversed());
                    for (Person p : searchedList) {
                        removedList.add(p);
                        peopleList.remove(p.id - 1);
                        entry++;
                    }
                    System.out.println("You deleted " + entry + " entries from the database:");
                    displayAllPeople(removedList);
                    removedList.clear();

                    System.out.println("Database after deleting specific entries:");
                    displayAllPeople(peopleList);

                } else if (userChoice == 2) {
                    System.out.println("No entries were removed from the database.");
                } else {
                    System.out.println("You need to choose one of the existing options.");
                }
            } else {
                System.out.println("\nUnfortunately no matching results were found.");
            }
            searchedList.clear();
        }
        else
        {
            System.out.println("No changes were applied to the database because of wrong input.");
        }

    }
    public static void add()
    {
        String userSurname = "";
        String userName = "";
        String userWork = "";
        int userAge = 0;

        Scanner inputAdd = new Scanner(System.in);
        System.out.print("You can add a new database entry here.\n");
        while(true) {
            System.out.print("Please enter surname: ");
            userSurname = inputAdd.nextLine().trim();
            if (Pattern.compile("[a-zA-Z \\-]+").matcher(userSurname).matches()) {
                userSurname = userSurname.toLowerCase().substring(0,1).toUpperCase() + userSurname.substring(1);
                break;
            }
            else
            {
                System.out.println("Enter the surname entry correctly: ");
            }
        }
        while(true) {
            System.out.print("Please enter name: ");
            userName = inputAdd.nextLine().trim();
            if (Pattern.compile("[a-zA-Z \\-]+").matcher(userName).matches()) {
                userName = userName.toLowerCase().substring(0,1).toUpperCase() + userName.substring(1);
                break;
            }
            else
            {
                System.out.println("Enter the name entry correctly: ");
            }
        }
        while(true) {
            System.out.print("Please enter profession: ");
            userWork = inputAdd.nextLine().trim();
            if (Pattern.compile("([a-zA-Z\\d\\p{Punct} ]+)").matcher(userWork).matches()) {
                userWork = userWork.toLowerCase().substring(0,1).toUpperCase() + userWork.substring(1);
                break;
            }
            else
            {
                System.out.println("Enter the profession entry correctly: ");
            }
        }
        while(true) {
            System.out.print("Please enter age: ");
            userAge = inputAdd.nextInt();
            if (Pattern.compile("\\d+").matcher(Integer.toString(userAge)).matches()) {
                break;
            }
            else
            {
                System.out.println("Enter the profession entry correctly: ");
            }
        }

        peopleList.add(new Person(peopleList.size() + 1, userSurname, userName, userWork, userAge));
        System.out.println("You added new entry to the database:");
        addedList.add(peopleList.get(peopleList.size() - 1));
        displayAllPeople(addedList);
        addedList.clear();

        System.out.println("Database after adding new entry:");
        displayAllPeople(peopleList);
    }
    public static void remove()
    {
        Scanner inputRemove = new Scanner(System.in);
        System.out.println("You can remove any elements from the database:");
        displayAllPeople(peopleList);

        System.out.println("Enter IDs index of the people you would like to remove from the database.\n" +
                "All of the IDs should be separated by semicolon!\n"
                + "Example: Enter 4;5 in order to remove people with id@4, id@5 :");

        StringBuilder toRemove = new StringBuilder(inputRemove.nextLine());

        if(Pattern.compile("(\\d+;?)+").matcher(toRemove).matches()) {

            if(Pattern.compile("(\\d;)+").matcher(toRemove).matches()) {
                toRemove.replace(toRemove.lastIndexOf(";"), toRemove.lastIndexOf(";") + 1, "");
            }

            LinkedList<String> idsToRemove = new LinkedList<>(Arrays.asList(toRemove.toString().trim().split(";")));
            idsToRemove.sort(Collections.reverseOrder());
            for(String id : idsToRemove)
            {
                System.out.println(id);
            }
            int entry = 0;
            for (String id : idsToRemove) {
                if (Integer.parseInt(id) > peopleList.get(peopleList.size() - 1).getId()) {
                    System.out.println("The entry with ID: id@" + id + " does not exist.");
                } else {
                    removedList.add(peopleList.get(Integer.parseInt(id) - 1));
                    peopleList.remove(Integer.parseInt(id) - 1);
                    entry++;
                }
            }
            System.out.println("You deleted " + entry + " entries from the database.");
            displayAllPeople(removedList);
            removedList.clear();
            System.out.println("Database after deleting specified entries:");
            displayAllPeople(peopleList);
        }
        else
        {
            System.out.println("No changes were applied on the database because of wrong input.");
        }
    }
    public static void createList()
    {
        Person p1 = new Person(1, "McKenzie", "Phillip", "Android App Developer", 19);
        peopleList.add(p1);
        Person p2 = new Person(2, "Sallivan", "Carmen", "3D Designer", 22);
        peopleList.add(p2);
        Person p3 = new Person(3, "Smith", "Bob", "UX/UI Designer", 45);
        peopleList.add(p3);
        Person p4 = new Person(4, "Rogers", "Greg", "C# Programmer", 28);
        peopleList.add(p4);
        Person p5 = new Person(5, "Zallander", "Mattie", "Statistics Specialist", 33);
        peopleList.add(p5);
    }
}
public class Main {

    public static void searchEngine() {
        System.out.println("Welcome to Shookay!\n");
        createList();
        while (true) {
            displayMenu();
            Scanner inputUser = new Scanner(System.in);
            int menu = inputUser.nextInt();

            switch (menu) {
                case 1 -> {
                    search();
                }
                case 2 -> {
                    add();
                }
                case 3 -> {
                    remove();
                }
                case 4 -> {
                    System.out.println("Thank you for choosing Shookay as your search engine! :)");
                    return;
                }
                default -> {
                    System.out.println("Choose the existing option from the menu.");
                }
            }
        }
    }

    public static void main(String[] args)  {
        searchEngine();
    }
}