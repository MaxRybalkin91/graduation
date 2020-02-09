/*
These passwords were encrypted there:
https://www.browserling.com/tools/bcrypt
*/
UPDATE users
SET password = /*password*/'$2a$08$w/KlRi6xvuy.DIjgW50TbuU5BvQmaqa1lYhF..KIYpqzPDHBy.NP6'
WHERE name IN ('owner1', 'owner2', 'owner3');

UPDATE users
SET password = /*owner*/'$2a$08$55qUQx4SMyfNcvbH7q.rCeVwHvmyF5y63.y/.nwc3.PM93ms.6mou'
WHERE name IN ('user1', 'user2', 'user3');

UPDATE users
SET password = /*admin*/'$2a$08$Cv2Es/ro4Spj3uTyCOxNgOyzWCsm7/3tn4101kGj5j0UsaXIH3vXW'
WHERE name = 'admin';