# Add new concert session

Adding a new concert session to database

**URL** : `/concert-sessions`

**Method** : `POST`

**Auth required** : YES

**Allowed for roles** : ADMIN

**Request body example** :
```json
{
     "stageId": 1,
     "showTime": "2021-08-09T18:31:42",
     "concertId": 1
}
```

## Success Responses
**Code** : `200 OK`

**Content example** : 

```json
{}
```