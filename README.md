This project provides the API's, which can be used by Delhi Metro.

Below are the API with Request Body.



// To register a User
URL :: http://localhost:8080/metro/registeruser
RequestBody :: 
{
        "name": "Sagar salal",
        "active": false
}

//To Register Card
URL :: http://localhost:8080/metro/registerCard/{userId}
Example : http://localhost:8080/metro/registerCard/3
RequestBody :: 
{
        "balance": "100"
}


//This API will be used while Swipe In
URL ::  http://localhost:8080/metro/swipein/{cardId}/{station}
Example : http://localhost:8080/metro/swipein/1/S8

//This API will be used while Swipe Out
URL :: http://localhost:8080/metro/swipeout/{cardId}/{station}
Example : http://localhost:8080/metro/swipeout/1/S1

//This API will provide the Card Details
URL : http://localhost:8080/metro/carddetail/{cardId}
Example : http://localhost:8080/metro/carddetail/1

Response :: 
{
    "user": {
        "id": 1,
        "name": "Sagar",
        "active": false
    },
    "transactions": [
        {
            "id": 1,
            "source": "S8",
            "destination": "S1",
            "startTime": "2020-01-12T19:32:38.406",
            "endTime": "2020-01-12T19:35:48.342",
            "balance": 100,
            "fare": 38.5
        }
    ],
    "balance": 61.5
}

// This Api will give all the details of Station Details
URL : http://localhost:8080/metro/stationdetail/{station}
Example : http://localhost:8080/metro/stationdetail/S1

Response : 
{
    "stationName": "S1",
    "swipeIn": [
        {
            "id": 2,
            "source": "S1",
            "destination": "S9",
            "startTime": "2020-01-12T20:20:09.951",
            "endTime": "2020-01-12T20:20:18.802",
            "balance": 61.5,
            "fare": 44
        }
    ],
    "swipeOut": [
        {
            "id": 1,
            "source": "S8",
            "destination": "S1",
            "startTime": "2020-01-12T20:19:45.139",
            "endTime": "2020-01-12T20:19:58.108",
            "balance": 100,
            "fare": 38.5
        }
    ]
}

// This API will be used to recharge smartCard
URL :: http://localhost:8080/metro/recharge/{cardId}/{balance}
Example :: http://localhost:8080/metro/recharge/1/1000


