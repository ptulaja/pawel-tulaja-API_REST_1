#!/usr/bin/env bash

if /usr/bin/env bash /Users/pawel/Documents/Development/Projects/tasks/runcrud.sh; then
    open http://localhost:8080/crud/v1/task/getTasks
else
    echo "There were errors."
fi
