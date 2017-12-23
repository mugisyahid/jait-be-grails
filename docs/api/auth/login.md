**Login**
----
  login in to system
  
* **PERMISSION**
  
  no auth required

* **URL**

  /login

* **Method:**
  
  `POST`
  
*  **URL Params**

  
   **Required:**
 
   

   **Optional:**
 
   
* **Data Params**
    json 
    
    ```json
    {
      "username" : "user",
      "password" : "password"
    }
    ```
  
* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** 
    
    ```json
        {
          "username": "test@kopong.com",
          "roles": [
            "ROLE_CUSTOMER"
          ],
          "token_type": "Bearer",
          "access_token": "eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTdjA4VVFSajk5cndMSkVSK21HaGlnWTNRa2IxRXkydVV5MGxpVnM1d1hJT0paRzczWXgxdWRtYWNtWVc3eGx5bEJRVkdKVEd4dGVRXC8wY1lcL3dFQmhTMjNMTjh2QkhqYkVxVFp2M3I3M3Z1XC9OOFJuVXJJSEhxV0ZjMkZDTFBPVXl0TnB3bVZxTWM4UGRNTXd0bWdSZHdWZ3JpRjFDNE9JRUZRZ2lxUERFd1oxb2wrMnh1bUF5cmJkN3V4aTd4c0RBSTJYU3NlS09ZUm51SzlNUHI3UmpaZkNhUVNrZGZLXC9BMUJZc3NEaFd1WFRyU3JZR21odE10bUMreENJVjl6MTBONllibEk0ellTZXBVeWhaVDJBU3dRekwzUnRGcmh5dGc3bUxzTG5qb3Q1QjE0aGdXak5yS2QwXC9rM1Njais3dmZVeEpFN3lGZDFBZDZJQU83VzdaVTBPdkV6YVZFRFExVjlJdWRXV21FcjdEdlRucGp4WVwvXC9UcjhOdXBXQUdnbkt6ZlwvVStMM1YySDA0XC9YZkI4V2lnOWpCdllub0phMHgwSlJtb1ZUZU5PaWRmMzk5K2ZubzdNT3JXK1RzR2NcLyt2NCtscCtQTkRac3EwOHd3cHlZNkl0bjlxdjhtOGRXYnhTOWJHSVlkbm1tQjlLS2t3K1RLb2hTbWNhdEdpY3Q5TzdpOTBZNWEyODF1WjdQOW9yWGhrVGxIWFQ3cEs2MWtTdklaUlpndE51Q3JDeU5DR3dkXC9QdjQ4ZkhoQ2NzK2h0c2RFamxUQWZFbGF6N01lbXZmSFI0c3pYMDRQaW5IR1Q3dDJEbWREMEgwZUF3QUEiLCJzdWIiOiJ0ZXN0QGtvcG9uZy5jb20iLCJyb2xlcyI6WyJST0xFX0NVU1RPTUVSIl0sImV4cCI6MTUxNDAzNjc2NSwiaWF0IjoxNTE0MDMzMTY1fQ.r-tOVp3JvlTNEEyOM70WGb5wRORm95cP6YxFIlJCMA0",
          "expires_in": 3600,
          "refresh_token": "eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTdjA4VVFSajk5cndMSkVSK21HaGlnWTNRa2IxRXkydVV5MGxpVnM1d1hJT0paRzczWXgxdWRtYWNtWVc3eGx5bEJRVkdKVEd4dGVRXC8wY1lcL3dFQmhTMjNMTjh2QkhqYkVxVFp2M3I3M3Z1XC9OOFJuVXJJSEhxV0ZjMkZDTFBPVXl0TnB3bVZxTWM4UGRNTXd0bWdSZHdWZ3JpRjFDNE9JRUZRZ2lxUERFd1oxb2wrMnh1bUF5cmJkN3V4aTd4c0RBSTJYU3NlS09ZUm51SzlNUHI3UmpaZkNhUVNrZGZLXC9BMUJZc3NEaFd1WFRyU3JZR21odE10bUMreENJVjl6MTBONllibEk0ellTZXBVeWhaVDJBU3dRekwzUnRGcmh5dGc3bUxzTG5qb3Q1QjE0aGdXak5yS2QwXC9rM1Njais3dmZVeEpFN3lGZDFBZDZJQU83VzdaVTBPdkV6YVZFRFExVjlJdWRXV21FcjdEdlRucGp4WVwvXC9UcjhOdXBXQUdnbkt6ZlwvVStMM1YySDA0XC9YZkI4V2lnOWpCdllub0phMHgwSlJtb1ZUZU5PaWRmMzk5K2ZubzdNT3JXK1RzR2NcLyt2NCtscCtQTkRac3EwOHd3cHlZNkl0bjlxdjhtOGRXYnhTOWJHSVlkbm1tQjlLS2t3K1RLb2hTbWNhdEdpY3Q5TzdpOTBZNWEyODF1WjdQOW9yWGhrVGxIWFQ3cEs2MWtTdklaUlpndE51Q3JDeU5DR3dkXC9QdjQ4ZkhoQ2NzK2h0c2RFamxUQWZFbGF6N01lbXZmSFI0c3pYMDRQaW5IR1Q3dDJEbWREMEgwZUF3QUEiLCJzdWIiOiJ0ZXN0QGtvcG9uZy5jb20iLCJyb2xlcyI6WyJST0xFX0NVU1RPTUVSIl0sImlhdCI6MTUxNDAzMzE2Nn0.E-ZBehwwMa_3lqeMPmJJ4WfweDhvxLZqHUgkIouAioE"
        }
    ```
    
 
* **Error Response:**

 
  * **Code:** 401 UNAUTHORIZED <br />
    
* **Sample Call:**

  
* **Notes:**

  