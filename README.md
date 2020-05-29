   COVID-19 INDIA TRACKER APP


The app displays the current status of covid19 infected cases across all the states and Union Terretories of India.It displays the Total confirmed cases,Active cases,Recovered and deceased cases. It also displays the last updated time and increase in cases.

Steps involved in creating the app.
Using Okhttp library , sent a request to the API and recieved the response using gson library.The response or the actual data in covid19 api was in the form of JSON(JavaScript Object Notation), parsed the Json statewise data using ROBO POJO Generator plugin  into a Kotlin Response class.
Fetched the last updated time on a seperate thread using coroutines. Displayed the overall data with images. Created a List adaptor and fetched data of state,active cases,...etc  from response.kt and set them to text views .Also created a seperate list view header xml. Finally created  A listview in Main activity and placed the adapter in the list view and also the header.Created a Spannable delta class so as to change the text of DeltaConfirmed,DeltaActive, DeltaDeceased and DeltaRecoveredCases and passed the text from ListAdapter to SpannableDelta Class so as to modify it partially.Also created a button to direct to next activity(having java class) via Intent .This activity contains the hyperlink to Json Api,Description and tools used in the app and also a brief note on Covid19.

IDE:
Android Studio

Api:
https://api.covid19india.org/data.json

Languages Used:
Kotlin 
Java

XML

Libraries Used:
OkHttp
Gson
Kotlin Couroutines

Plugin Used:
 ROBO POJO Generator




