# basicliti-java-sample-toolconsumer

LTI1.1 Tool Consumerのサンプルプログラムです。

## ビルド

このリポジトリをcloneし、以下のコマンドを実行してください。

```
./gradlew build -x test
```

## 起動

カレントディレクトリに、遷移先の情報を記載したapplication.ymlを作成してください。
```yaml
tools:
  - name: 識別名
    url: 遷移先URL
    key: キー(UUID)
    secret: シークレット
```
urlとkey, secretは、LTIでの遷移先(Tool Provider)と合わせる必要があります。

次に、ビルドにより生成されたファイルをjavaコマンドで起動してください。対応しているJavaのバージョンは17以降です。

```
java -jar build/libs/basiclti-java-sample-toolconsumer-0.0.1NAPSHOT.jar
```

起動すると、以下のURLにブラウザでアクセスすると遷移先一覧が表示されます。

 - http://localhost:8080/basiclti-java-sample-toolconsumer/

遷移先をクリックし、次の画面で Go ボタンをクリックすると、実際に遷移先にLTIに準拠したPOSTリクエストが送信されます。
