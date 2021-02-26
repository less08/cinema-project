# Get all orders

Get list of all user's orders

**URL** : `/orders`

**Method** : `GET`

**Auth required** : YES

**Allowed for roles** : USER

## Success Response

**Code** : `200 OK`

**Content example**:

  private Long id;
    private List<Long> ticketIds;
    private String orderDate;
    private String userEmail;
```json
[
    {
        "id": 1,
        "ticketIds": [1,2,3,4,5],
        "orderDate": "2021-08-09T18:31:42",
        "userEmail": "sample"
    }
]
```