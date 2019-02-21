# Windows Asset File bug

1. Run `./gradlew  a:conAndTest`
2. Observe test fails
3. Rename `src/main/assets/Documents/Bookingatest/BookingaTest.htm` -> `src/main/assets/Documents/Bookingatest/Bookingatest.htm` (lowercase 't'est)
4. Rerun `./gradlew a:conAndTest`
5. Observe test fails and check APK for assets director which is empty
