## Reactive API of users where you can add, update and fetch users -

Reactive API of users built with Spring webflux API and storing data in elastic search via elastic search APIs.

Need local instance running of elastic seach server.

![user](https://user-images.githubusercontent.com/8009104/215382277-00fd7ad4-de86-4532-9b06-82255497680e.png)


## Download elastic server windows version from this place -

```
https://www.elastic.co/downloads/elasticsearch
```
Once downloaded, go inside the bin folder from the downloaded place -

```
D:\elasticSearch\elasticsearch-7.8.0-windows-x86_64\elasticsearch-7.8.0\bin
```

And run the windows batch file which will start the server and access the URL given below - 

```
http://localhost:9200
```

You will get the response JSON as such which indicates that its started and working - 

```
{
  "name" : "YY189299",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "0GpdyWYRR2-jfjcSXBrnGA",
  "version" : {
    "number" : "7.8.0",
    "build_flavor" : "default",
    "build_type" : "zip",
    "build_hash" : "757314695644ea9a1dc2fecd26d1a43856725e65",
    "build_date" : "2020-06-14T19:35:50.234439Z",
    "build_snapshot" : false,
    "lucene_version" : "8.5.1",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}
```
## Start the java application with this command - 

```
java -jar ReactiveAPIWithElasticSearch.jar 
```

## Hit the Rest endpoints with the following operations- 

```
curl --location --request POST 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": "123",
    "firstName": "Tenzin",
    "lastName": "Dawa",
    "occupation": "Software Engineer",
    "age": "30",
    "dateOfBirth": "04-05-1992"
}'
```
```
curl --location --request PUT 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": "123",
    "firstName": "Tenzin",
    "lastName": "Dawa",
    "occupation": "Software Engineer",
    "age": "31",
    "dateOfBirth": "04-05-1992"
}'
```
```
curl --location --request GET 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw ''
```
```
curl --location --request GET 'http://localhost:8080/users/123' \
--header 'Content-Type: application/json' \
--data-raw ''
```
