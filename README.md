# Social Media App
The application contains classes such as User, Post, LikePost

User Class:
It contains the general details of user like username, password

Post Class:
It contains the post details like title, content and userId

LikePost Class:
It contains the details like postId, list of users who liked the post

# Steps to run the application
1. Git clone **https://github.com/Sai-Deekshith974/social-media-app.git**
2. Install Apache Maven
3. Open CMD in the folder path
4. Run **mvn clean install -DskipTests** which creates the jar file in /target folder
5. Execute **cd target**
6. Run **java -jar jarFileName.jar**
7. Now, the application will run in port 8080

# CURLs for the REST APIs

**Create User**

curl --location 'http://localhost:8080/auth/register' \
--header 'Content-Type: application/json' \
--data '{
    "userName": "sai-deekshith",
    "password": "password",
    "confirmPassword": "password"
}'

**Output**
<img width="1381" height="646" alt="image" src="https://github.com/user-attachments/assets/76c64081-cecd-4300-a033-0aa1aae1cb7f" />


**User Login**

curl --location 'http://localhost:8080/auth/login' \
--header 'Content-Type: application/json' \
--data '{
    "userName": "sai-deekshith",
    "password": "password"
}'

**Output**
<img width="1372" height="615" alt="image" src="https://github.com/user-attachments/assets/de91bb86-0c65-44cd-b62e-cb23ccf23cea" />

- Copy the jwt token and paste it after "Bearer" in Authorization.
- Now, Find the curl below to create the post.

**Create Post**

curl --location 'http://localhost:8080/api/createPost' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzYWktZGVla3NoaXRoIiwiaWF0IjoxNzUzMzUyMTYxLCJleHAiOjE3NTMzODgxNjF9.giAbdxEDHTFmb-gdNrEFK3eB71b9120dXLROsF2P4x4' \
--header 'Content-Type: application/json' \
--data '{
    "title": "New images with AI",
    "content": "some content",
    "userId": "sai-deekshith"
}'

**Output**
<img width="1385" height="628" alt="image" src="https://github.com/user-attachments/assets/424db661-f10e-40c3-9cbe-da2e6dda5238" />

**Get all posts**

curl --location 'http://localhost:8080/api/getAllPosts' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzYWktZGVla3NoaXRoIiwiaWF0IjoxNzUzMzUyMTYxLCJleHAiOjE3NTMzODgxNjF9.giAbdxEDHTFmb-gdNrEFK3eB71b9120dXLROsF2P4x4'

**Output**
<img width="1372" height="673" alt="image" src="https://github.com/user-attachments/assets/5102160e-0eea-49b9-804d-aedb34ffb117" />

**Like Post**

curl --location --request POST 'http://localhost:8080/api/likeThePost/sai-deekshith/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzYWktZGVla3NoaXRoIiwiaWF0IjoxNzUzMzUyMTYxLCJleHAiOjE3NTMzODgxNjF9.giAbdxEDHTFmb-gdNrEFK3eB71b9120dXLROsF2P4x4' \
--data ''

**Output**
<img width="1366" height="602" alt="image" src="https://github.com/user-attachments/assets/b7785277-277a-4d42-ab10-2c887d8b0472" />

**Delete Post**

curl --location --request DELETE 'http://localhost:8080/api/deletePost/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzYWktZGVla3NoaXRoIiwiaWF0IjoxNzUzMzUyMTYxLCJleHAiOjE3NTMzODgxNjF9.giAbdxEDHTFmb-gdNrEFK3eB71b9120dXLROsF2P4x4'

**Output**
<img width="1372" height="550" alt="image" src="https://github.com/user-attachments/assets/b3cfd720-29bc-4449-ab28-f3afb1c0e0ab" />

