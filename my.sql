

CREATE PROCEDURE RECORDSET

@pi_intAccountNo            INT,
@pi_strBankCode           VARCHAR(50),

@pi_intPageSize         INT         = 10,       -- 페이지 표시개수
@pi_intPageNo           INT         = 1,        -- 페이지 번호
@po_intRecordCnt        INT         = 0 OUTPUT  -- 전체 로우수

AS


-------------------------------------------------
--Variable Declare
-------------------------------------------------
DECLARE @v_intStartRow      INT
DECLARE @v_intStartSeqNo    VARCHAR(50)        
DECLARE @v_strSql           NVARCHAR(4000)
DECLARE @v_strSqlWhere      NVARCHAR(4000)

-------------------------------------------------
--Variable Initialize
-------------------------------------------------
SET @v_strSql = ''
SET @v_strSqlWhere = ''

-------------------------------------------------------
--1. 변수및조건문정의
-------------------------------------------------------
SET @v_intStartRow = (@pi_intPageNo - 1) * @pi_intPageSize + 1

IF ISNULL(@pi_intAccountNo,0) <> 0 BEGIN
    SET @v_strSqlWhere = @v_strSqlWhere + N' AND ACCOUNTNO = @pi_intAccountNo'
END
IF ISNULL(@pi_strBankCode,'') <> '' BEGIN
    SET @v_strSqlWhere = @v_strSqlWhere + N' AND BANKCODE = @pi_strBankCode'
END


-------------------------------------------------------
--2. 전체갯수조회
-------------------------------------------------------
SET @v_strSql = ''
SET @v_strSql = @v_strSql + N'
    SELECT  @po_intRecordCnt = COUNT(*)
    FROM    DEALINFO WITH(NOLOCK)
    WHERE   1 = 1 '
SET @v_strSql = @v_strSql + @v_strSqlWhere 

EXEC SP_EXECUTESQL @v_strSql
    ,N'@po_intRecordCnt INT OUTPUT
      ,@pi_intAccountNo INT
      ,@pi_strBankCode  VARCHAR(50)'
    ,@po_intRecordCnt OUTPUT
    ,@pi_intAccountNo = @pi_intAccountNo
    ,@pi_strBankCode = @pi_strBankCode



-------------------------------------------------------
--3. 리스트조회
-------------------------------------------------------
SET ROWCOUNT @pi_intPageSize

SET @v_strSql = ''
SET @v_strSql = @v_strSql + N'
    WITH ABC AS (

    SELECT   DEALNO
            ,ACCOUNTNO
            ,BANKCODE
            ,DEALDATE
            ,DEALSTATE
            ,DEALHELP
            ,DEALMONEY
            ,BALANCE
            ,ROW_NUMBER() OVER ( ORDER BY DEALNO ASC) AS ROWNUM
    FROM DEALINFO WITH(NOLOCK)
    WHERE   1 = 1 '
SET @v_strSql = @v_strSql + @v_strSqlWhere
SET @v_strSql = @v_strSql + N'
    ) '
SET @v_strSql = @v_strSql + N'SELECT * FROM ABC WHERE ROWNUM >= '+CAST(@v_intStartRow AS VARCHAR) + ' ORDER BY ROWNUM'


EXEC SP_EXECUTESQL @v_strSql
    ,N'@po_intRecordCnt INT OUTPUT
      ,@pi_intAccountNo INT
      ,@pi_strBankCode  VARCHAR(50)'
    ,@po_intRecordCnt OUTPUT
    ,@pi_intAccountNo = @pi_intAccountNo
    ,@pi_strBankCode = @pi_strBankCode



RETURN

GO
DECLARE @po_intRecordCount INT
EXEC RECORDSET 2001, 'B02', 10, 3, @po_intRecordCount
PRINT @po_intRecordCount

SELECT * FROM DEALINFO WHERE ACCOUNTNO = 2001 AND BANKCODE = 'B02'
