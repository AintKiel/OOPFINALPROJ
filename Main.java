import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    private static int qualifierCount = 0;
    private static int age;
    private static String firstName;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Define the Scanner instance
        String text = "SCHOLARGATE";

        // Add spaces between letters
        String spacedText = text.replaceAll("(.)", "$1 "); // Correct regex to add spaces

        // Styling
        String border = "*".repeat(spacedText.length() + 4);
        String paddedText = "* " + spacedText + "*";

        // Display the styled text
        System.out.println(border);
        System.out.println(paddedText);
        System.out.println(border);

        System.out.println("\n\n=== Scholarship Terms and Conditions ===\n");

        // Display scholarship terms and conditions
        displayTermsAndConditions();

        // Loop to handle acceptance input
        while (true) {
            System.out.print("\nDo you accept these terms? (Y/N): ");
            char agree = scanner.nextLine().charAt(0); // Get the first character of the input

            char lowerAgree = Character.toLowerCase(agree); // Convert to lowercase for comparison

            switch (lowerAgree) {
                case 'y':
                    System.out.println("\nThank you for accepting the terms.");
                    break;

                case 'n':
                    System.out.println("You did not accept the terms. Application cannot proceed.");
                    scanner.close(); // Close the scanner before exiting
                    System.exit(0); // Stop the program

                default:
                    System.out.println("Invalid input. Please enter 'Y' for yes or 'N' for no."); // Prompt for valid input
                    continue;
            }

            // Loop to submit application or exit
            while (true) {
                // Call the method to gather user details
                infoDetails(scanner);

                // Check eligibility
                eligCriteria(scanner);

                // Ask if the user wants to submit another application
                System.out.print("\nWould you like to submit another application? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                infoDetails(scanner);

                if (!response.equals("yes")) {
                    System.out.println("Thank you for using the Scholarship Eligibility System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }

    // Function to display scholarship terms and conditions
    public static void displayTermsAndConditions() {
        System.out.println("1. Eligibility");
        System.out.println("   - Applicants must be full-time students at an accredited institution,");
        System.out.println("     meet GPA requirements, fulfill residency and must be 16 and above.\n");

        System.out.println("2. Application Requirements");
        System.out.println("   - Applications, including all required documents, must be complete and");
        System.out.println("     submitted by the deadline. By applying, applicants confirm that all");
        System.out.println("     provided information is accurate.\n");

        System.out.println("3. Selection Process");
        System.out.println("   - Recipients are selected based on academic merit, financial need, or other");
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

    // Function to gather applicant details
    public static void infoDetails(Scanner scanner) {
        // Collecting Full Name
        System.out.print("\n\nEnter your first name: ");
        firstName = scanner.nextLine();

        System.out.print("Enter your middle name (or press Enter to skip): ");
        String middleName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        // Collecting Birthdate and Calculating Age
        System.out.print("Enter your birthdate (YYYY-MM-DD): ");
        String birthDateInput = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateInput);
        age = calculateAge(birthDate);

        // Collecting Gender (Optional)
        System.out.print("Enter your gender (M/F/Other): ");
        String genderInput = scanner.nextLine();
        String gender = switch (genderInput.toLowerCase()) {
            case "m" -> "Male";
            case "f" -> "Female";
            default -> "Prefer not to say";
        };

        // Collecting Citizenship or Nationality
        System.out.print("Enter your nationality: ");
        String nationality = scanner.nextLine();

        // Collecting Residential Address
        System.out.print("Enter your residential country: ");
        String country = scanner.nextLine();

        System.out.print("Enter your state/province: ");
        String state = scanner.nextLine();

        System.out.print("Enter your city: ");
        String city = scanner.nextLine();

        System.out.print("Enter your postal code: ");
        String postalCode = scanner.nextLine();

        // Collecting Email
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        // Collecting Education Level with numbered choices
        System.out.println("Select your education level:");
        System.out.println("1. Senior High School");
        System.out.println("2. College");
        System.out.print("Enter your choice (1 or 2): ");
        int educationChoice = scanner.nextInt();
        String educationLevel = switch (educationChoice) {
            case 1 -> "Senior High School";
            case 2 -> "College";
            default -> "Not Specified";
        };
        scanner.nextLine(); // Consume the newline character

        // Collecting Academic Institution
        System.out.print("Enter your current academic institution: ");
        String academicInstitution = scanner.nextLine();

        // Collecting Extracurricular Activities (Optional)
        System.out.print("Enter your extracurricular activities (or press Enter to skip): ");
        String extracurriculars = scanner.nextLine();

        // Display Collected Information
        System.out.println("\n=== Applicant Information ===");
        System.out.println("Full Name: " + firstName + " " + (middleName.isEmpty() ? "" : middleName + " ") + lastName);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Nationality: " + nationality);
        System.out.println("Address: " + city + ", " + state + ", " + country + " - " + postalCode);
        System.out.println("Email: " + email);
        System.out.println("Education Level: " + educationLevel);
        System.out.println("Academic Institution: " + academicInstitution);
        System.out.println("Extracurricular Activities: " + (extracurriculars.isEmpty() ? "None" : extracurriculars));

        while (true) {
            System.out.print("\nIs the information above correct? (Y/N): ");
            char infoCheck = scanner.nextLine().charAt(0);

            char lowerInfoCheck = Character.toLowerCase(infoCheck);

            switch (lowerInfoCheck) {
                case 'y':
                    System.out.println("\nProceeding to Eligibility Criteria.....");
                    return;
                case 'n':
                    System.out.println("Running Applicant's Information again");
                    infoDetails(scanner);
                    return;
                default:
                    System.out.println("Invalid input. Please enter 'Y' for yes or 'N' for no.");
            }
        }
    }

    public static int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    public static void eligCriteria(Scanner scanner) {
        System.out.println("\n\n=== Eligibility Criteria ===");
        String peso = "\u20B1";

        System.out.print("Enter your GPA or Average Grade: ");
        double gpaOrGrade = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left by nextDouble

        System.out.println("\nPlease select your family weekly income range:");
        System.out.println("1. Below " + peso + "10,000");
        System.out.println("2. " + peso + "10,000 - " + peso + "30,000");
        System.out.println("3. " + peso + "30,000 - " + peso + "50,000");
        System.out.println("4. " + peso + "50,000 - " + peso + "80,000");
        System.out.println("5. Above " + peso + "80,000");
        System.out.print("Enter your choice (1-5): ");
        int incomeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left by nextInt

        String incomeRange = switch (incomeChoice) {
            case 1 -> "Below " + peso + "10,000";
            case 2 -> peso + "10,000 - " + peso + "30,000";
            case 3 -> peso + "30,000 - " + peso + "50,000";
            case 4 -> peso + "50,000 - " + peso + "80,000";
            case 5 -> "Above " + peso + "80,000";
            default -> "Not Specified";
        };

        System.out.println("\n=== Eligibility Information ===");
        System.out.println("GPA / Grade: " + String.format("%.2f", gpaOrGrade));
        System.out.println("Income Range: " + incomeRange);

        boolean meetsEligibility = (gpaOrGrade <= 2.5) && (incomeChoice <= 3) && (age >= 16 && age <= 24);
        String decision;

        // Set the decision message based on eligibility
        if (meetsEligibility) {
        decision = "QUALIFIED";
        } else {
        decision = "Not Qualified";
        }

        if (meetsEligibility) {
            // Increment qualifier count and assign a serial number
            qualifierCount++;
        }

        String serNum = String.format("%04d", qualifierCount);

        if (meetsEligibility) {
            System.out.println(decision);
            System.out.println("\n\nApplicant number: " + serNum);
            System.out.println("\nCongratulations " + firstName + "! You meet the basic eligibility criteria for the scholarship.");
            System.out.println("You can now proceed to the next step of the selection process.");
            System.out.println("Please check your email for further instructions. You will soon receive an email with details \non the required documents to submit for a deeper analysis.");
            System.out.println("Submitting these documents promptly will help finalize your qualification for the scholarship. Best of luck!\n\n");
        } else {
            System.out.println("Unfortunately, you do not meet the basic eligibility criteria for the scholarship.");
        }

        scanner.close();
    }
}

