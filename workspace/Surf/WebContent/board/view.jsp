<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>
<script type="text/javascript">
	function check(f){
		if(f.content.value == ""){
			alert("댓글을 입력하세요!");
			f.content.focus();
			return;
		}
		
		f.action = "/Surf/board/commentWrite.brd";
		f.submit();
	}
	
	function checkDelete(){
		if(confirm('이 게시글을 삭제하시겠습니까?')){
			location.href="/Surf/board/delete.brd?seq=${boardVO.seq}";
		}
	}
</script>

	<div align="center" class="boardView">
		<h3>${boardVO.title }</h3>
		<hr>
		<p class="writerInfo">
			<font style="font-weight: bold;">아이디 : </font> ${boardVO.id } &nbsp;
			<font style="font-weight: bold;"> 작성일 : </font> ${boardVO.logtime } &nbsp;
			<font style="font-weight: bold;"> 조회수 : </font> ${boardVO.hit } &nbsp;
		</p>
		
		<div class="viewContent">
			<pre>${boardVO.content }</pre>
		</div>
		<div class="fileComment">
			<c:if test="${boardVO.filename != null }">
				<font>첨부파일</font> &nbsp;&nbsp;
				<a href="/Surf/board/fileDownload.brd?seq=${boardVO.seq }&filename=${boardVO.filename}">${boardVO.filename }</a>
			</c:if>
		</div>
	
		<br>
		<div class="viewButton">
			<button type="button" onclick="location.href='/Surf/board/list.brd?pg=${pg}'">목록</button>
			<c:if test="${login == boardVO.id }">
				<button type="button" onclick="location.href='/Surf/board/modifyForm.brd?pg=${pg}&seq=${boardVO.seq}'">수정</button>
				<button type="button" onclick="checkDelete()">삭제</button>
			</c:if>
		</div>
		
		<!-- 댓글 -->
		<div class="commentView">
			<c:choose>
				<c:when test="${isEmpty}">
					<p> 아직 댓글이 없습니다. </p>
				</c:when>
				<c:otherwise>
					<c:forEach var="com" items="${comList }">
						<div class="commentEach">
							<font style="font-size: 12pt; font-weight: bold;">${com.id }</font> &nbsp; <font style="font-size: 6pt">${com.logtime }</font> <br>
							&nbsp;<font>${com.content }</font>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<br>
			<div>
				<c:if test="${login != null }">
					<form>
						<br>
						<font style="font-size: 12px;">${login }</font> <br>
						<span class="writeComment">
							<textarea name="content" rows="3" cols="112" placeholder="댓글을 작성하세요"></textarea>
						</span>
						<span class="submitComment">
							<input type="hidden" value="${boardVO.seq }" name="board_no">
							<input type="button" value="등록" onclick="check(this.form)">
						</span>
					</form>
				</c:if>
			</div>
		</div>
	</div>
<%@ include file="/layout/footer.jsp"%>