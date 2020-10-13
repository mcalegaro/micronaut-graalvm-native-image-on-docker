FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/mn
WORKDIR /home/app/mn

RUN native-image --no-server -cp target/mn-*.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8081
COPY --from=graalvm /home/app/mn .
ENTRYPOINT ["./mn"]