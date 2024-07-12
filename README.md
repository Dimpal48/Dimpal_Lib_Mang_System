# Dimpal_Lib_Mang_System
Assumptions Made:
1. The Book entity references the Author entity through the authorId field.
   
2.The database schema will be initialized on startup, so there's no need to pre-populate the database with data.

3.The application uses an H2 in-memory database for simplicity and ease of setup.

4.Basic error handling is implemented, throwing a runtime exception when a book is not found. 
