# Get all concert sessions

Get list of all available concert sessions

**URL** : `/concert-sessions/available`

**Method** : `GET`

**Auth required** : YES

**Allowed for roles** : USER, ADMIN

**Query params**:   

    date: string - required
    concertId: number - required

**Query params example**:

    concertId=1
    date=21.02.2021`
    
## Success Response

**Code** : `200 OK`

**Content example**:
```json
[
    {
        "concertSessionId": 1,
        "showTime": "2021-08-09T18:31:42",
        "concertTitle": "Mozart's night",
        "stageId": 1
    }
]
```