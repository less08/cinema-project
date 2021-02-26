# Get user's shopping cart

**URL** : `/shopping-carts/by-user`

**Method** : `GET`

**Auth required** : YES

**Allowed for roles** : USER
    
## Success Response

**Code** : `200 OK`

    private List<Long> ticketIds;
**Content example**:
```json
  {
       "id": 1,
       "ticketIds": [1,2,3,4,5],
       "userEmail": "sample"
  }
```