# JavaStudy

## Примерный ответ
```
<soap:Envelope
	xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
	<soap:Body>
		<ns2:getByLoginResponse
			xmlns:ns2="http://goods.ws.app.logrocon.ru/">
			<return>
				<goodList>
					<good id="1">
						<name>Товар 1</name>
					</good>
					<good id="3">
						<name>Товар 3</name>
					</good>
				</goodList>
			</return>
		</ns2:getByLoginResponse>
	</soap:Body>
</soap:Envelope>
```