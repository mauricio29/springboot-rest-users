# springboot-rest-users

# TODO WIP en progreso ...

* CURL example usages:

* $ curl -v -X GET localhost:8080/users

* $ curl -v -X GET localhost:8080/users/1

* $ curl -v -X DELETE localhost:8080/users/1

* $ curl -v -X POST localhost:8080/users \
    -H "Content-type:application/json" \
    -d "{\"name\":\"Bash Name\", \"email\":\"bash@srv.com\",\"password\":\"supersecure\",\"phone\":\"2020\"}"
	# POST - new user

* $	curl -v -X PUT localhost:8080/users/1 \
	-H "Content-type:application/json" \
	-d "{\"id\":\"1\", \"name\":\"Bash Name\", \"email\":\"bash@srv.com\",\"password\":\"newPassword***\",\"phone\":\"2020\"}"
	# PUT - without ID field in body

* $	curl -v -X PUT localhost:8080/users/1 \
	-H "Content-type:application/json" \
	-d "{\"id\":\"1\", \"name\":\"Bash Name\", \"email\":\"bash@srv.com\",\"password\":\"newPassword***\",\"phone\":\"2020\"}"
	# PUT con ID en body e igual parámetro

* $	curl -v -X PUT localhost:8080/users/1 \
	-H "Content-type:application/json" \
	-d "{\"id\":\"11\", \"name\":\"Bash Name\", \"email\":\"bash@srv.com\",\"password\":\"newPassword***\",\"phone\":\"2020\"}"
	# PUT con ID diferente en body

* $ curl -v -X PATCH localhost:8080/users/1 \
	-H "Content-type:application/json" \
	-d "{\"name\":\"Other Name\"}"
	# PATCH
