@SmokeTest
Feature: Login function test
@TC_01
Scenario: As a Luma application user, must do successful login with valid credential. 
Given open any browser
And go to application URL
When click signin button
And put Email
And put password
And click second signin button
Then validate login was successful 