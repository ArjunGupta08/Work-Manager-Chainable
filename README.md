# Chainable Work 
## You can perform some task in a chain using chainable work manager

 - Project SetUp
    
        val workVersion = "2.9.0"
    
        // (Java only)
        implementation("androidx.work:work-runtime:$workVersion")
    
        // Kotlin + coroutines
        implementation("androidx.work:work-runtime-ktx:$workVersion")

 - Create your worker classes
 - Here i've created three worker classes
 - initialise your one time work request for each worker class
       
        OneTimeWorkRequest oneTimeWorkRequest1 = new OneTimeWorkRequest.Builder(WorkA.class).build();
        OneTimeWorkRequest oneTimeWorkRequest2 = new OneTimeWorkRequest.Builder(WorkB.class).build();
        OneTimeWorkRequest oneTimeWorkRequest3 = new OneTimeWorkRequest.Builder(WorkC.class).build();
 - Now Perform each work in a chain using WorkManager

        WorkManager.getInstance(this)
            .beginWith(oneTimeWorkRequest1)
            .then(oneTimeWorkRequest2)
            .then(oneTimeWorkRequest3)
            .enqueue();
- You can also use constraints for every individual work

       Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build();
        OneTimeWorkRequest oneTimeWorkRequest1 = new OneTimeWorkRequest.Builder(WorkA.class)
                .setConstraints(constraints)
                .build();
# ` NOTE -`
![Screenshot 2024-03-07 133903](https://github.com/ArjunGupta08/Work-Manager-Chainable/assets/85922120/8b1b71ef-0e99-48d3-ad55-8bc89f6ed180)
  
