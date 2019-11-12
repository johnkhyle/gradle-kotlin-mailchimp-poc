# gradle-kotlin-mailchimp-poc

**General Info**

Using [MaleOrang wrapper](https://github.com/Ecwid/maleorang) to access [MailChimp API v3.0](https://mailchimp.com/developer/reference/) 
#### **Install**

first you need to generate or find your API key if you already created one if not you can follow this [MailChimp guide](https://mailchimp.com/help/about-api-keys/) 
to generate one. The second requirement you need to [create](https://mailchimp.com/help/create-audience/) an audience/list, 
or if you already have one [find your audience id](https://mailchimp.com/help/find-audience-id/). Once you gather the api key and the audience id place the api key in [MailChimpService](src/main/kotlin/com/example/gradlekotlinmailchimppoc/MailChimpService.kt)
line 12 and line 13 for the audience id.

**Build the app**  

`./gradlew clean build` 

if permission is denied 

`chmod +x ./gradlew`

then 

`./gradlew clean build`


**Start the App**

`./gradlew bootRun`


## **Access the API**


### **Subscribe**

**POST** `localhost:8080/api/subscribe`

Request body JSON format sample 

`{
    "email":"example@example.com,
    "firstName": Sample,
    "lastName": Data
}
`

### **Unsubscribe**

**PATCH** `localhost:8080/api/unsubscribe?email=yourEmailHere@example.com`

### **Resubscribe**

**PATCH** `localhost:8080/api/resubscribe?email=yourEmailHere@example.com`

### **Update Info** 

Only for first name and last name merge fields

Request body JSON format sample 

**PUT** `localhost:8080/api/updateInfo`

`{
    "email":"example@example.com,
    "firstName": Updated,
    "lastName": Data Here
}
`

### **Delete**

Archive the contact not permanently delete
 
**DELETE** `localhost:8080/api/delete?email=yourEmailHere@example.com`
