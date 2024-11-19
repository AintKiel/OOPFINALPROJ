import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Scholargates {
    private static int qualifierCount = 0;
    private static int age;
    private static String firstName;
    private static String educationLevel;
    private static String country;
    private static String pronoun; 
    private static int incomeChoice;

    // Getters and Setters
    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Scholargates.age = age;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        Scholargates.firstName = firstName;
    }

    public static String getEducationLevel() {
        return educationLevel;
    }

    public static void setEducationLevel(String educationLevel) {
        Scholargates.educationLevel = educationLevel;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        Scholargates.country = country;
    }

    public static String getPronoun() {
        return pronoun;
    }

    public static void setPronoun(String pronoun) {
        Scholargates.pronoun = pronoun;
    }

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String text = "SCHOLARGATE";

    String spacedText = text.replaceAll("(.)", "$1 ");

    String border = "*".repeat(spacedText.length() + 4);
    String paddedText = "* " + spacedText + "*";

    String greyText = "\u001B[37m";
    String blueText = "\u001B[34m";  
    String resetText = "\u001B[0m"; 

    System.out.println("\n\n\t   " + greyText + border + resetText);
    System.out.println("\t   " + blueText + paddedText + resetText);
    System.out.println("\t   " + greyText + border + resetText);

    System.out.println("\n\n=== Scholarship Terms and Conditions ===\n");

    displayTermsAndConditions();

    while (true) {
        System.out.print("\nDo you accept these terms? (Y/N): ");
        String agreeInput = scanner.nextLine().trim().toLowerCase();
        if (agreeInput.length() == 0) continue;
        char agree = agreeInput.charAt(0);

        switch (agree) {
            case 'y':
                System.out.println("\nThank you for accepting the terms.");
                break;
            case 'n':
                System.out.println("\nYou did not accept the terms. Application cannot proceed.");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("\nInvalid input. Please enter 'Y' for yes or 'N' for no.");
                continue;
        }

        clearScreen();


        while (true) {
            clearScreen();
        
            infoDetails(scanner);
            familyDetails(scanner);
            eligCriteria(scanner);
        
            System.out.print("\nWould you like to submit another application? (Y/N): ");
            String response = scanner.nextLine().trim().toLowerCase();
        
            if (!response.equals("y")) {
                System.out.println("\nThank you for using the Scholarship Eligibility System. Goodbye!");
                break; 
            }
        }

    }
}

//clear screen part
public static void clearScreen() {
    System.out.print("\u001B[2J");
    System.out.flush();  
    System.out.print("\u001B[H"); 
}

public static void displayTermsAndConditions() {
    System.out.println("1. Eligibility");
    System.out.println("   - Applicants must be full-time students at an accredited institution,");
    System.out.println("     meet GPA requirements, fulfill residency and must be 16 and above.\n");

    System.out.println("2. Application Requirements");
    System.out.println("   - Applications, including all required documents, must be complete and");
    System.out.println("     submitted by the deadline. By applying, applicants confirm that all");
    System.out.println("     provided information is accurate.\n");

    System.out.println("3. Selection Process");
    System.out.println("   - Recipients are selected based on academic merit (You should have 2.5 or 85% and above GWA), \nfinancial need (Not exceeding 50,000 php of monthly income), or other");
    System.out.println("     stated criteria. All committee decisions are final.\n");

    System.out.println("4. Award Conditions");
    System.out.println("   - Scholarship funds must be used for educational expenses and are non-transferable.");
    System.out.println("     Recipients must maintain the required GPA.\n");

    System.out.println("5. Fund Disbursement");
    System.out.println("   - Funds are sent directly to the institution or as specified and may be disbursed");
    System.out.println("     in installments. Failure to meet academic standards may lead to termination of funds.\n");

    System.out.println("6. Recipient Responsibilities");
    System.out.println("   - Recipients may be asked to participate in promotional activities and must report");
    System.out.println("     any changes in academic status. Misrepresentation or misconduct may lead to revocation.\n");

    System.out.println("7. Privacy");
    System.out.println("   - Applicant information is used solely for scholarship administration and protected");
    System.out.println("     in line with privacy laws.\n");

    System.out.println("8. Acceptance");
    System.out.println("   - \"I have read and understood the scholarship terms and conditions outlined in the application. ");
    System.out.println("     I agree to abide by all requirements and responsibilities associated with this scholarship, ");
    System.out.println("     including maintaining the required GPA and using the funds for educational purposes only.\"");
}

public static void infoDetails(Scanner scanner) {
    int educationChoice;
    String gender;
    LocalDate birthDate;

    String border = "===================================================";
    String yellow = "\u001B[33m";
    String reset = "\u001B[0m";

    System.out.println("\n" + border);
    System.out.println(yellow + "             APPLICANT'S INFORMATION           " + reset);
    System.out.println(border + "\n");

    
    System.out.print("Enter your first name: ");
    firstName = scanner.nextLine();

    System.out.print("Enter your middle name (or press Enter to skip): ");
    String middleName = scanner.nextLine();

    System.out.print("Enter your last name: ");
    String lastName = scanner.nextLine();

    while (true) {
        System.out.print("Enter your birthdate (YYYY-MM-DD): ");
        String birthDateInput = scanner.nextLine();
        try {
            birthDate = LocalDate.parse(birthDateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            age = calculateAge(birthDate);
            break;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
        }
    }

    while (true) {
        System.out.print("Enter your gender (M/F): ");
        String genderInput = scanner.nextLine().trim().toLowerCase();
        gender = switch (genderInput) {
            case "m" -> {
                pronoun = "Mr. " + firstName; 
                yield "Male";
            }
            case "f" -> {
                pronoun = "Ms. " + firstName; 
                yield "Female";
            }
            default -> null;
        };
        if (gender != null) break;
        System.out.println("Invalid input. Please enter M or F only.");
    }

    System.out.print("Enter your nationality: ");
    String nationality = scanner.nextLine();

    System.out.print("Enter your residential country: ");
    country = scanner.nextLine();

    System.out.print("Enter your state/province: ");
    String state = scanner.nextLine();

    System.out.print("Enter your city: ");
    String city = scanner.nextLine();

    System.out.print("Enter your postal code: ");
    String postalCode = scanner.nextLine();

    System.out.print("Enter your email address: ");
    String email = scanner.nextLine();

    while (true) {
        System.out.println("Select your education level:");
        System.out.println("1. Senior High School");
        System.out.println("2. College");
        System.out.print("Enter your choice (1 or 2): ");
        educationChoice = scanner.nextInt();
        scanner.nextLine(); 
        educationLevel = switch (educationChoice) {
            case 1 -> "Senior High School";
            case 2 -> "College";
            default -> null;
        };
        if (educationLevel != null) break;
        System.out.println("Invalid choice. Please enter 1 or 2.");
    }

    System.out.print("Enter your current academic institution: ");
    String academicInstitution = scanner.nextLine();

    System.out.print("Enter your extracurricular activities (or press Enter to skip): ");
    String extracurriculars = scanner.nextLine();

    clearScreen();

    String topBorder = "=====================================================";
    String bottomBorder = "=====================================================";
    String divider = "=====================================================";

    System.out.println("\n" + topBorder);
    System.out.println( yellow + "|               APPLICANT INFORMATION               |" + reset);
    System.out.println(bottomBorder);

    System.out.println(divider);
    System.out.printf("%-25s: %s\n", "Full Name", firstName + " " + (middleName.isEmpty() ? "" : middleName + " ") + lastName);
    System.out.printf("%-25s: %d\n", "Age", age);
    System.out.printf("%-25s: %s\n", "Gender", gender);
    System.out.printf("%-25s: %s\n", "Nationality", nationality);
    System.out.printf("%-25s: %s\n", "Address", city + ", " + state + ", " + country + " - " + postalCode);
    System.out.printf("%-25s: %s\n", "Email", email);
    System.out.printf("%-25s: %s\n", "Education Level", educationLevel);
    System.out.printf("%-25s: %s\n", "Academic Institution", academicInstitution);
    System.out.printf("%-25s: %s\n", "Extracurricular Activities", extracurriculars.isEmpty() ? "None" : extracurriculars);
    System.out.println(divider);


    while (true) {
        System.out.print("\nDo you confirm that the information provided is accurate? (Y/N): ");
        char confirmation = scanner.nextLine().charAt(0);
        if (Character.toLowerCase(confirmation) == 'y') break;
        if (Character.toLowerCase(confirmation) == 'n') {
            System.out.println("Please re-enter your details carefully.");
            infoDetails(scanner);
        } else {
            System.out.println("Invalid input. Please enter Y or N.");
        }
    }
}


public static void familyDetails(Scanner scanner) {
    clearScreen();

    String peso = "\u20B1";
    String yellow = "\u001B[33m";
    String reset = "\u001B[0m";

    System.out.println("\n\n==========================================");
    System.out.println("      " + yellow + "***** FAMILY BACKGROUND *****" + reset);
    System.out.println("==========================================");

    System.out.println("\n  -- Father Information --");
    System.out.print("\nEnter father's name: ");
    String fatherName = scanner.nextLine();
    System.out.print("Enter father's age: ");
    int fatherAge = Integer.parseInt(scanner.nextLine()); 
    System.out.print("Enter father's address: ");
    String fatherAddress = scanner.nextLine();
    System.out.print("Enter father's occupation: ");
    String fatherOccupation = scanner.nextLine();
    System.out.print("Enter father's monthly income: ");
    double fatherMonthlyIncome = Double.parseDouble(scanner.nextLine()); 

    String fatherEducationalAttainment;
    while (true) {
        System.out.println("\nSelect Father's highest educational attainment (1-6): ");
        System.out.println("1. Elementary");
        System.out.println("2. Highschool Graduate");
        System.out.println("3. Highschool Undergraduate");
        System.out.println("4. Vocational Education");
        System.out.println("5. College Graduate");
        System.out.println("6. College Undergraduate");
        System.out.print("Choose between 1-6: ");
        int choice = Integer.parseInt(scanner.nextLine()); 

        fatherEducationalAttainment = switch (choice) {
            case 1 -> "Elementary";
            case 2 -> "Highschool Graduate";
            case 3 -> "Highschool Undergraduate";
            case 4 -> "Vocational Education";
            case 5 -> "College Graduate";
            case 6 -> "College Undergraduate";
            default -> null;
        };

        if (fatherEducationalAttainment != null) break;
        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
    }

    String fatherHealthStatus;
    String fatherAdditionalInfo = ""; 
    while (true) {
        System.out.println("\nSelect Father's Health Status (1-4): ");
        System.out.println("1. Normal");
        System.out.println("2. Unalive");
        System.out.println("3. Person with disability");
        System.out.println("4. Diseased");
        System.out.print("Choose between 1-4: ");
        int healthChoice = Integer.parseInt(scanner.nextLine()); 

        fatherHealthStatus = switch (healthChoice) {
            case 1 -> "Normal";
            case 2 -> "Unalive";
            case 3 -> "Person with disability";
            case 4 -> "Diseased";
            default -> null;
        };

        if (fatherHealthStatus != null) {
            if (healthChoice == 3) {
                System.out.print("Please specify the type of disability: ");
                fatherAdditionalInfo = scanner.nextLine();
            } else if (healthChoice == 4) {
                System.out.print("Please specify the type of disease: ");
                fatherAdditionalInfo = scanner.nextLine();
            }
            break;
        }
        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
    }

    System.out.print("\nEnter father's contact number: ");
    String fatherContactNumber = scanner.nextLine();

    // Mother's Details
    System.out.println("\n  -- Mother Information --");
    System.out.print("\nEnter mother's name: ");
    String motherName = scanner.nextLine();
    System.out.print("Enter mother's age: ");
    int motherAge = Integer.parseInt(scanner.nextLine()); 
    System.out.print("Enter mother's address: ");
    String motherAddress = scanner.nextLine();
    System.out.print("Enter mother's occupation: ");
    String motherOccupation = scanner.nextLine();
    System.out.print("Enter mother's monthly income: ");
    double motherMonthlyIncome = Double.parseDouble(scanner.nextLine()); 

    String motherEducationalAttainment;
    while (true) {
        System.out.println("\nSelect Mother's highest educational attainment (1-6): ");
        System.out.println("1. Elementary");
        System.out.println("2. Highschool Graduate");
        System.out.println("3. Highschool Undergraduate");
        System.out.println("4. Vocational Education");
        System.out.println("5. College Graduate");
        System.out.println("6. College Undergraduate");
        System.out.print("Choose between 1-6: ");
        int choice = Integer.parseInt(scanner.nextLine()); 

        motherEducationalAttainment = switch (choice) {
            case 1 -> "Elementary";
            case 2 -> "Highschool Graduate";
            case 3 -> "Highschool Undergraduate";
            case 4 -> "Vocational Education";
            case 5 -> "College Graduate";
            case 6 -> "College Undergraduate";
            default -> null;
        };

        if (motherEducationalAttainment != null) break;
        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
    }

    String motherHealthStatus;
    String motherAdditionalInfo = "";
    while (true) {
        System.out.println("\nSelect Mother's Health Status (1-4): ");
        System.out.println("1. Normal");
        System.out.println("2. Unalive");
        System.out.println("3. Person with disability");
        System.out.println("4. Diseased");
        System.out.print("Choose between 1-4: ");
        int healthChoice = Integer.parseInt(scanner.nextLine()); 

        motherHealthStatus = switch (healthChoice) {
            case 1 -> "Normal";
            case 2 -> "Unalive";
            case 3 -> "Person with disability";
            case 4 -> "Diseased";
            default -> null;
        };

        if (motherHealthStatus != null) {
            if (healthChoice == 3) {
                System.out.print("Please specify the type of disability: ");
                motherAdditionalInfo = scanner.nextLine();
            } else if (healthChoice == 4) {
                System.out.print("Please specify the type of disease: ");
                motherAdditionalInfo = scanner.nextLine();
            }
            break;
        }
        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
    }

    System.out.print("\nEnter mother's contact number: ");
    String motherContactNumber = scanner.nextLine();

    // General Family Information
    System.out.println("\n-- General Family Information --");
    System.out.print("\nEnter number of siblings: ");
    int numberOfSiblings = Integer.parseInt(scanner.nextLine());
    System.out.print("Enter number of vehicle/s: ");
    int numberOfVehicles = Integer.parseInt(scanner.nextLine()); 

    String familyIncome;
    while (true) {
        System.out.println("\nPlease select your family weekly income range:");
        System.out.println("1. Below " + peso + "10,000");
        System.out.println("2. " + peso + "11,000 - " + peso + "30,000");
        System.out.println("3. " + peso + "31,000 - " + peso + "50,000");
        System.out.println("4. " + peso + "51,000 - " + peso + "80,000");
        System.out.println("5. Above " + peso + "80,000");
        System.out.print("Enter your choice (1-5): ");
        incomeChoice = Integer.parseInt(scanner.nextLine()); 

        familyIncome = switch (incomeChoice) {
            case 1 -> "Below " + peso + "10,000";
            case 2 -> peso + "11,000 - " + peso + "30,000";
            case 3 -> peso + "31,000 - " + peso + "50,000";
            case 4 -> peso + "51,000 - " + peso + "80,000";
            case 5 -> "Above " + peso + "80,000";
            default -> null;
        };

        if (familyIncome != null) break;
        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
    }

    String housingDescription;
    while (true) {
        System.out.println("\nHow would you describe your housing? (1-5): ");
        System.out.println("1. Owns a house");
        System.out.println("2. Lives with others");
        System.out.println("3. Homeless");
        System.out.println("4. Not the owner of the house but renting or staying in it");
        System.out.print("Choose between 1-4: ");
        int housingStatus = scanner.nextInt();
        scanner.nextLine(); 

        housingDescription = switch (housingStatus) {
            case 1 -> "Owns a house";
            case 2 -> "Lives with others";
            case 3 -> "Homeless";
            case 4 -> "Not the owner of the house but renting or staying in it";
            default -> null;
        };

        if (housingDescription != null) break;
        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
    }

    clearScreen();

    System.out.println("\n=============================================");
    System.out.println("      " + yellow + "***** FAMILY BACKGROUND *****" + reset);
    System.out.println("=============================================");

    System.out.println("\nFather's Information:");
    System.out.println("=============================================");
    System.out.printf("Name:             %s\n", fatherName);
    System.out.printf("Age:              %d\n", fatherAge);
    System.out.printf("Address:          %s\n", fatherAddress);
    System.out.printf("Occupation:       %s\n", fatherOccupation);
    System.out.printf("Monthly Income:   %.2f\n", fatherMonthlyIncome);
    System.out.printf("Education:        %s\n", fatherEducationalAttainment);
    System.out.printf("Health Status:    %s %s\n", fatherHealthStatus, fatherAdditionalInfo.isEmpty() ? "" : "- " + fatherAdditionalInfo);
    System.out.printf("Contact Number:   %s\n", fatherContactNumber);

    System.out.println("\nMother's Information:");
    System.out.println("=============================================");
    System.out.printf("Name:             %s\n", motherName);
    System.out.printf("Age:              %d\n", motherAge);
    System.out.printf("Address:          %s\n", motherAddress);
    System.out.printf("Occupation:       %s\n", motherOccupation);
    System.out.printf("Monthly Income:   %.2f\n", motherMonthlyIncome);
    System.out.printf("Education:        %s\n", motherEducationalAttainment);
    System.out.printf("Health Status:    %s %s\n", motherHealthStatus, motherAdditionalInfo.isEmpty() ? "" : "- " + motherAdditionalInfo);
    System.out.printf("Contact Number:   %s\n", motherContactNumber);

    System.out.println("\nGeneral Family Information:");
    System.out.println("=============================================");
    System.out.printf("Number of Siblings:      %d\n", numberOfSiblings);
    System.out.printf("Number of Vehicles:      %d\n", numberOfVehicles);
    System.out.printf("Family Monthly Income:   %s\n", familyIncome);
    System.out.printf("House Description:       %s\n", housingDescription);

    while (true) {
        System.out.print("\nDo you confirm that the information provided is accurate? (Y/N): ");
        char confirmation = scanner.nextLine().charAt(0);
        if (Character.toLowerCase(confirmation) == 'y') break;
        if (Character.toLowerCase(confirmation) == 'n') {
            System.out.println("Please re-enter your details carefully.");
            familyDetails(scanner);
            return; 
        } else {
            System.out.println("Invalid input. Please enter Y or N.");
        }
    }
}

public static void eligCriteria(Scanner scanner) {
    clearScreen();
    double gpaOrGrade;
    String red = "\u001B[31m";
    String green = "\u001B[32m";
    String yellow = "\u001B[33m";
    String reset = "\u001B[0m";

    System.out.println("\n=============================================");
    System.out.println("      " + yellow + "***** EDUCATIONAL BACKGROUND *****" + reset);
    System.out.println("=============================================");

    if (educationLevel.equals("Senior High School")) {
        //elementary info
        System.out.println("\n\nElementary Background Information:");
        System.out.println("=============================================");
        System.out.print("\nEnter your school in Elementary: ");
        String elemSchool = scanner.nextLine();
        System.out.print("Enter the year you graduated: ");                        
        int elemYearGrad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your General Average: ");
        double elemGenAve = scanner.nextDouble();
        scanner.nextLine(); 
        
        //high school info
        System.out.println("\n\nJunior High School Background Information:");
        System.out.println("=============================================");
        System.out.print("\nEnter your school in Junior HighSchool: ");
        String jhsSchool = scanner.nextLine();
        System.out.print("Enter the year you graduated: ");
        int jhsYearGrad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your General Average: ");
        double jhsGenAve = scanner.nextDouble();
        scanner.nextLine(); 

        //senior high info
        System.out.println("\n\nSenior High School Background Information:");
        System.out.println("=============================================");
        System.out.print("\nEnter your school in Senior HighSchool: ");
        String shsSchool = scanner.nextLine();
        System.out.print("Enter your strand: ");
        String shsStrand = scanner.nextLine();
        System.out.print("Enter your General Average: ");
        gpaOrGrade = scanner.nextDouble();
        scanner.nextLine();

        clearScreen();
        System.out.println("\n=============================================");
        System.out.println("      " + yellow + "***** EDUCATIONAL BACKGROUND *****" + reset);
        System.out.println("=============================================");
        System.out.println("\nElementary Information");
        System.out.printf("\nName of School:           %s\n", elemSchool);
        System.out.printf("Year Graduated:           %d\n", elemYearGrad);
        System.out.printf("General Average:          %s\n", elemGenAve);

        System.out.println("\nJunior High School Information");
        System.out.printf("\nName of School:           %s\n", jhsSchool);
        System.out.printf("Year Graduated:           %d\n", jhsYearGrad);
        System.out.printf("General Average:          %s\n", jhsGenAve);

        System.out.println("\nSenior High School Information");
        System.out.printf("\nName of School:           %s\n", shsSchool);
        System.out.printf("Strand:                   %s\n", shsStrand);
        System.out.printf("General Average:          %s\n", gpaOrGrade);
        System.out.println("=============================================");

        while (true) {
            System.out.print("\nDo you confirm that the information provided is accurate? (Y/N): ");
            char confirmation = scanner.nextLine().charAt(0);
            if (Character.toLowerCase(confirmation) == 'y') break;
            if (Character.toLowerCase(confirmation) == 'n') {
                System.out.println("Please re-enter your details carefully.");
                eligCriteria(scanner);
                return; 
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    } 
    
    else {
        //elementary info
        System.out.println("\n\nElementary Background Information:");
        System.out.println("=============================================");
        System.out.print("\nEnter your school in Elementary: ");
        String elemSchool = scanner.nextLine();
        System.out.print("Enter the year you graduated: ");
        int elemYearGrad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your General Average: ");
        double elemGenAve = scanner.nextDouble();
        scanner.nextLine(); 
    
        //high school info
        System.out.println("\n\nJunior High School Background Information:");
        System.out.println("=============================================");
        System.out.print("\nEnter your school in Junior HighSchool: ");
        String jhsSchool = scanner.nextLine();
        System.out.print("Enter the year you graduated: ");
        int jhsYearGrad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your General Average: ");
        double jhsGenAve = scanner.nextDouble();
        scanner.nextLine();

        //senior high info
        System.out.println("\n\nSenior High School Background Information:");
        System.out.println("=============================================");
        System.out.print("\nEnter your school in Senior HighSchool: ");
        String shsSchool = scanner.nextLine();
        System.out.print("Enter your strand: ");
        String shsStrand = scanner.nextLine();
        System.out.print("Enter the year you graduated: ");
        int shsYearGrad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your General Average: ");
        double shsGenAve = scanner.nextDouble();
        scanner.nextLine();

        // College info
        System.out.println("\n\nCollege Background Information:");
        System.out.println("=============================================");
        System.out.print("Enter your college: ");
        String collegeSchool = scanner.nextLine();
        System.out.print("Enter your program: ");
        String colProgram = scanner.nextLine();  
        System.out.print("Enter your GPA: ");
        gpaOrGrade = scanner.nextDouble();
        scanner.nextLine();  

        clearScreen();
        System.out.println("\n=============================================");
        System.out.println("      " + yellow + "***** EDUCATIONAL BACKGROUND *****" + reset);
        System.out.println("=============================================");
        System.out.println("\nElementary Information");
        System.out.printf("\nName of School:           %s\n", elemSchool);
        System.out.printf("Year Graduated:           %d\n", elemYearGrad);
        System.out.printf("General Average:          %s\n", elemGenAve);

        System.out.println("\nJunior High School Information");
        System.out.printf("\nName of School:           %s\n", jhsSchool);
        System.out.printf("Year Graduated:           %d\n", jhsYearGrad);
        System.out.printf("General Average:          %s\n", jhsGenAve);

        System.out.println("\nSenior High School Information");
        System.out.printf("\nName of School:           %s\n", shsSchool);
        System.out.printf("Strand:                   %s\n", shsStrand);
        System.out.printf("Year Graduated:           %d\n", shsYearGrad);
        System.out.printf("General Average:          %s\n", shsGenAve);

        System.out.println("\nSenior High School Information");
        System.out.printf("\nName of School:           %s\n", collegeSchool);
        System.out.printf("Program:                  %s\n", colProgram);
        System.out.printf("General Average:          %s\n", gpaOrGrade);

        System.out.println("=============================================");

        while (true) {
            System.out.print("\nDo you confirm that the information provided is accurate? (Y/N): ");
            char confirmation = scanner.nextLine().charAt(0);
            if (Character.toLowerCase(confirmation) == 'y') break;
            if (Character.toLowerCase(confirmation) == 'n') {
                System.out.println("Please re-enter your details carefully.");
                eligCriteria(scanner);
                return;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }


    // Check eligibility based on education level
    EligibilityCriteria eligibility;
    if (educationLevel.equals("Senior High School")) {
        eligibility = new SeniorHighSchoolEligibility();
    } else {
        eligibility = new CollegeEligibility();
    }

    clearScreen();

    String decision = eligibility.checkEligibility(age, gpaOrGrade, incomeChoice, country) ? "QUALIFIED" : "Not Qualified";

    if (eligibility.checkEligibility(age, gpaOrGrade, incomeChoice, country)) {
        qualifierCount++;
        String serNum = String.format("%04d", qualifierCount);
        String border = "====================================================";
        System.out.println("\n" + border);
        System.out.println("             " + green + "*** CONGRATULATIONS! ***" + reset);
        System.out.println(border);
        System.out.println("\nStatus: " + decision);
        System.out.println("\nApplicant Number: " + serNum);
        System.out.println("\nDear " + pronoun + ",");
        System.out.println("You have successfully met the basic eligibility criteria for the scholarship!");
        System.out.println("\nNext Steps:");
        System.out.println("1. Please check your email for further instructions.");
        System.out.println("2. You will receive details on the required documents for the next stage.");
        System.out.println("\nPrompt submission of these documents will help finalize your qualification.");
        System.out.println("We wish you the best of luck in the selection process!");
        System.out.println(border + "\n\n");
    } else {
        String border = "****************************************************";
        System.out.println("\n" + border);
        System.out.println("           " + red + "*** SORRY, NOT QUALIFIED ***" + reset);
        System.out.println(border);
        System.out.println("\nStatus: " + decision);
        System.out.println("\nUnfortunately, you do not meet the basic eligibility criteria for the scholarship.");

        if (!eligibility.meetsGpaCriteria()) {
            System.out.println("\nReason: Your grade does not meet the required threshold.");
        }
        if (!eligibility.meetsIncomeCriteria()) {
            System.out.println("\nReason: Monthly income must not exceed 50,000 PHP.");
        }
        if (!eligibility.meetsAgeCriteria()) {
            System.out.println("\nReason: You did not meet the age requirement.");
        }
        if (!eligibility.meetsCountryCriteria()) {
            System.out.println("\nReason: You must be a resident of the Philippines.");
        }
        System.out.println(border + "\n");
    }
}
    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
