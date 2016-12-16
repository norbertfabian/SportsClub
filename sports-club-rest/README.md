#REST API

This project implements REST API for entity Team. Hereby, its useage is described.
Location:
```
http://SERVER_ADDRESS/pa165/rest/team/
```

| Title        | URL           | Method |  Params  | Data params (JSON) |
| ------------- |:-------------:| :-----:|:-----:| :-----:|
| Get all teams  | `/` | GET   |  |    |
| Get team      | `/{id}` |   GET   |  Team ID  |      |
| Create new team | `/` |  POST |    |  { "id": ID_NUMBER, "name": "TEAM_NAME"}  |
| Update team | `/{id}` |  PUT |  Team ID  |  |
| Create new team | `/{id}` |  DELETE |  Team ID  |   |

##Example usage:
Using external program, e.g. `curl`, you can test the API
```
curl -i http://localhost:8080/pa165/rest/team/
```
will return JSON containing all the data about teams in application.
