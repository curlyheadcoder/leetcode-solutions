# Write your MySQL query statement below
select firstName, lastName, city, state from Person
Left Join address on Person.PersonId = Address.PersonId;