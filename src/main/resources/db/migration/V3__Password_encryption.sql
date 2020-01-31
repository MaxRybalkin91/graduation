/*
These passwords were encrypted there:
https://www.browserling.com/tools/bcrypt
*/
UPDATE users
SET password = '$2a$08$onJmizwAA2IrJbm55ExE8uZUu6dohWbSpildyzsGjHyfKR2Ips12q'
WHERE name IN ('admin');

UPDATE users
SET password = '$2a$08$55qUQx4SMyfNcvbH7q.rCeVwHvmyF5y63.y/.nwc3.PM93ms.6mou'
WHERE name IN ('user', 'user2');