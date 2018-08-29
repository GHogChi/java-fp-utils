# java-fp-utils
Utility classes to mitigate some Java problems and make Java code more FP-like.

## Result
Use this family of classes and never throw an exception or pass a null
again.

Of course you'll have to catch exceptions from old school code that
insists on throwing them, but you can wrap them in an ExceptionalError
and return it in the Result.

### NOTE:
These classes were written using strict TDD, but I have not included the
tests in this project.