## easter-logging

This is project is a homework exercise, part of DE PTI Software Development Course's curriculum.

The application iterates through an easter themed verse and logs to the console and different files 
based on the instructions of the exercise.

The maven-exec-plugin is configured to run the example with an argument "2".

```
<plugin>
    ...
    <configuration>
        ...
        <arguments>
            <argument>2</argument>
        </arguments>
    </configuration>
</plugin>
```

If there are no arguments the application will only iterate through the verse once.