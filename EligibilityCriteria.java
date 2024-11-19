public interface EligibilityCriteria {
    boolean checkEligibility(int age, double gpaOrGrade, int incomeChoice, String country);
    boolean meetsGpaCriteria();
    boolean meetsIncomeCriteria();
    boolean meetsAgeCriteria();
    boolean meetsCountryCriteria();
}