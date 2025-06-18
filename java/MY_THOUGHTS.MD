## Assumptions & Notes

- Interest for basic plan starts after 30 days.
- Interest for Student plan starts after 30 days and stops after 1 year.
- Premium plan accrues interest **after** 45 days only.
- We assume time deposits are only in months (30-day approximation).
- for basic plan, interest started > 30 days, but it was not mentioned in the README. i have updated it now

## Constraints

- Must support Spring Boot 3.5.0 and java 17
- Only in-memory H2 database for now.
- All APIs must be RESTful and return standard HTTP codes.

## design constraints
- Since the guideline was not to change the database schema, i did not. But the schema would have been better
- for now, hard coded all the rules for plan types, but we cna extend it to inject dynamically as rules tend to change often
- Junits - for readability purpose i have elaborated each scenario into one test case. we can minimize it and have less code 
- logging would have been better

NOTE : had some environment issues with my github initially in intellij, so you can see some discrepancies in initial commits