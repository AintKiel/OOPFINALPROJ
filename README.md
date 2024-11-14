<img src="assets/SCHOLARGATE.png" alt="SCHOLARGATE Logo" width="200">

![SCHOLARGATE](https://github.com/user-attachments/assets/fcf88545-cd98-4608-a6e0-7092460daf00)

# **Project Overview**

  The **Scholargates Scholarship Eligibility System** is a Java-based console application designed to assist students in determining their preliminary eligibility for a scholarship based on specific criteria. It provides an interactive interface for users to input their personal and academic details, check eligibility against predefined rules, and receive a real-time result.

  The application covers eligibility for two education levels: **Senior High School** and **College**, and considers factors like **age, GPA, family income,** and **nationality** (restricted to residents of the Philippines).

**Key Features:**

User-friendly command-line interface for data input.

Dynamic eligibility checks based on various criteria.

Clear feedback on eligibility status, including specific reasons for rejection if not qualified.

Preliminary Qualification Test: Meeting the basic criteria doesn’t guarantee final qualification, as applicants must go through a more in-depth analysis. This initial step is called the “GATE”—an eligibility test 
to determine initial suitability.

This system is designed to be easy to use for students applying for scholarships and offers a transparent way to check basic qualifications.

# **OOP Principles Applied**

**1. Abstraction**

The EligibilityCriteria interface defines the blueprint for eligibility checks. It abstracts away the complexity of the eligibility logic and exposes methods for specific checks.
The abstract class Eligibility provides common functionality for checking age, country, and income criteria, which is shared by both SeniorHighSchoolEligibility and CollegeEligibility.

**2. Encapsulation**

The program uses private fields with getter and setter methods in the Scholargates class to protect user data such as name, age, country, and education level.
The eligibility checking logic is encapsulated in the classes SeniorHighSchoolEligibility and CollegeEligibility, ensuring each class handles its own criteria while using shared functionality for common checks.

**3. Inheritance**

The classes SeniorHighSchoolEligibility and CollegeEligibility inherit from the abstract class Eligibility and override the checkEligibility method to implement their specific eligibility criteria for each education level.

**4. Polymorphism**

The method checkEligibility in the EligibilityCriteria interface is implemented differently in SeniorHighSchoolEligibility and CollegeEligibility, showcasing method overriding.
The eligibility check behaves differently depending on whether the user selects Senior High School or College, using polymorphism to dynamically adapt to the user’s input.

# **Chosen SDG and Its Integration**
The chosen Sustainable Development Goal (SDG) for this project is SDG 4: Quality Education. This goal aims to ensure inclusive and equitable quality education and promote lifelong learning opportunities for all.

**Integration:**

Scholarship for All: The application encourages students from underprivileged backgrounds, particularly in the Philippines, to apply for scholarships based on their academic performance and financial need.

Inclusivity: The system checks eligibility based on academic performance (GPA), income levels, and age, providing an equal opportunity for students who meet the scholarship's criteria, regardless of their financial background.

### Instruction for Running the Program

1. **Use Visual Studio Code (VSCode)**  
   Visual Studio Code (VSCode) is a recommended editor, but you can use any code editor you prefer.

2. **Input Your Details**  
   - Launch the program as specified in the setup, then follow the prompts to input your personal details.

3. **Check and Confirm Your Details**  
   - Before moving to the next page, double-check all details you've entered to ensure they’re accurate.

4. **Submit Additional Applications if Needed**  
   - If desired, you have the option to submit multiple applications through the program.

5. **Await Email Confirmation if Qualified**  
   - If your application meets the qualifications, you’ll receive an email with further instructions for the next steps.


