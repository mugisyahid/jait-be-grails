**Login**
----
  registering user

* **PERMISSION**
    
    no auth required

* **URL**

  /register

* **Method:**
  
  `POST`
  
*  **URL Params**

  
   **Required:**
 
   

   **Optional:**
 
   
* **Data Params**
    json 
    
    ```json
    {
      "username": "test@kopong.com",
      "name": "test",
      "password": "pass",
      "enabled": false,
      "accountExpired": false,
      "accountLocked": false,
      "passwordExpired": false,
      "remark": "keterangan jati diri - huehue",
      "roles": [ "ROLE_CUSTOMER" ]
      }
    ```
  
* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** 
    
    ```json
        {
          "_links": {
            "self": {
              "href": "http://localhost:8080/admin/user/5",
              "hreflang": "en_US",
              "type": "application/hal+json"
            }
          },
          "username": "test@kopong.com",
          "name": "test",
          "remark": "keterangan jati diri - huehue"
        }
    ```
    
 
* **Error Response:**

 
  * **Code:** 200 <br />
  ```json
  {
    "errors": [
      {
        "object": "com.jait.command.admin.RegisterCommand",
        "field": "name",
        "rejected-value": null,
        "message": "Property [name] of class [class com.jait.command.admin.RegisterCommand] cannot be null"
      },
      {
        "object": "com.jait.command.admin.RegisterCommand",
        "field": "password",
        "rejected-value": null,
        "message": "Property [password] of class [class com.jait.command.admin.RegisterCommand] cannot be null"
      }
    ]
  }
  ```
    
* **Sample Call:**

  
* **Notes:**

  