# Flickr


Description:
The Task was to develop a Image gallery using the Flickr api's i.e from the provided link in the email and provide the details regarding the images like
image title, dimensions etc.Below were the ecisions that were required for developing the application.

1. First of all I had to undestood the use of Flickr api and their usage before integrating the api with the anroid application.
2. Decide the result data format fot the api.
3. Then to decide which library to use for the api call.
4. Decide the view to be used for the imager gallery

Solutions:
1. First I undestood the working of the Flickr api. first the al is made for the images using the link
https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=eac62e41c47d62737e4d600acd47433f&format=json
This api provides the details for the images such as its id , owner id, secret id etc not the exact url of the image 
in order to get the image url we need to call the following url 
http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg 
and replace the parameters in the url that we get from the previous api.

2. I have decided to use the json format for the api responce since it is more convenient to to use and i hve more experience in using the json format for the api.

3. I have used the retrofit library for making the api request for this application.
Retrofit is a REST client for Android, through which you can make easy to use interfaces which can turn any Android app into a powerful one.
Retrofit can perform Async and sync requests with automatic JSON parsing without any effort. It's responce is fast than any other method.
Retrofit has full support for Post Requests and Multipart uploads.

4. For displaying the images I have used the RecycleView instead of ListView since it provides smooth scrolling and is more optimized than the ListView.
   The reason behind this is that it uses the viewHolder in the implimentation. 
   
   
Note: Please use the application with internet connection, because of the limited time I have not implemented the validations in the applications like  internet 
and api on response validatons.