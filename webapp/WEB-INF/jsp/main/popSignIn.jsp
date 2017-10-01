<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
$('#btnSignUp').click(function() {
	var $href = $(this).attr('href');
	layer_popup($href);
});

$('#btnClose').click(function() {
	var $href = $(this).attr('href');
	layer_popup($href);
});
</script>

<div class="dim-layer">
	<div class="dimBg"></div>
	<div id="popSignIn" class="pop-layer">
		<div class="pop-container">
			<!-- <div class="pop-conts"> -->
			<!--content //-->
			<h2>sign up</h2>
			<div class="row uniform">
				<div class="12u$">
					<input type="text" name="name" value="" class="small" placeholder="Nic Name" />
				</div>
				<div class="12u$">
					<input type="email" name="email" value="" placeholder="Email" />
				</div>
				<div class="12u$">
					<input type="password" name="password" value="" placeholder="Password" />
				</div>
				<div class="12u$">
					<input type="password" name="passwordConfirm" value="" placeholder="Password Confirm" />
				</div>
				<div class="12u$">
					<ul class="actions small align-right">
						<li><input type="button" id="btnSignUp" value="Sign Up" class="small special" /></li>
						<li><input type="button" id="btnClose" value="Close" class="small special" /></li>
					</ul>
				</div>
			</div>
			<!--// content-->
			<!-- </div> -->
		</div>
	</div>
</div>