This are my conclusions from the benchmarking I've made this tool. For peace of mind run it yourself, changing the parameters is pretty straigh forward ;).

All ICS Tests have been made with CyanogenMod 9 stable and all Gingerbread have been made with CyanogenMod 7.2 stable.

Direct VS Reflection for Static Methods Calls in ICS
-----------------------------------------------------

07-05 18:42:58.413: VERBOSE/JavaBench(7932): will now test Reflection calls to a class.
07-05 18:42:58.783: DEBUG/JavaBench(7932): 1 Reflection method calls took: 364
07-05 18:42:58.803: VERBOSE/JavaBench(7932): will now test Direct calls to a class.
07-05 18:42:59.093: DEBUG/JavaBench(7932): 1 Direct method calls took: 293

07-05 18:43:24.013: VERBOSE/JavaBench(8320): will now test Reflection calls to a class.
07-05 18:43:24.743: DEBUG/JavaBench(8320): 100 Reflection method calls took: 726
07-05 18:43:24.753: VERBOSE/JavaBench(8320): will now test Direct calls to a class.
07-05 18:43:25.363: DEBUG/JavaBench(8320): 100 Direct method calls took: 606

07-05 18:43:48.523: VERBOSE/JavaBench(8588): will now test Reflection calls to a class.
07-05 18:43:48.653: DEBUG/JavaBench(8588): 1000 Reflection method calls took: 122
07-05 18:43:49.433: VERBOSE/JavaBench(8588): will now test Direct calls to a class.
07-05 18:43:49.443: DEBUG/JavaBench(8588): 1000 Direct method calls took: 10

07-05 18:54:10.523: VERBOSE/JavaBench(9516): will now test Reflection calls to a class.
07-05 18:54:10.863: DEBUG/JavaBench(9516): 10000 Reflection method calls took: 309
07-05 18:54:10.863: VERBOSE/JavaBench(9516): will now test Direct calls to a class.
07-05 18:54:10.863: DEBUG/JavaBench(9516): 10000 Direct method calls took: 4


These tests have been run in a row. In the later calls, 1000 calls get really fast, that's because of warm-up :).
Still there is some overhead in calling via Reflection VS Direct Calls for static methods.

Direct VS Reflection for Static Methods Calls in Gingerbread
--------------------------------------------------------------------

07-05 18:57:28.194: VERBOSE/JavaBench(19019): will now test Reflection calls to a class.
07-05 18:57:28.858: DEBUG/JavaBench(19019): 10000 Reflection method calls took: 655
07-05 18:57:28.952: VERBOSE/JavaBench(19019): will now test Direct calls to a class.
07-05 18:57:28.952: DEBUG/JavaBench(19019): 10000 Direct method calls took: 1

In Gingerbread warm-up and caching really wins to reflection when calling methods in a loop.